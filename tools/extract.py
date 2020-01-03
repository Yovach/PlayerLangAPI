import json
import re

categories = (
    # 'multiplayer',
    # 'chat',
    # 'disconnect',
    # 'death',
    'color',
    'item',
    'block|tile',
    'gameMode',
    'key',
    'item',
    'entity',
    'effect',
    'potion',
    'enchantment',
    'attribute',
    'resourcepack',
    'commands',
    'arguments',
    'parsing',
    'biome',
)

excluded_patterns = [
    'hotbar',
    'categories',
]


def is_categorized(value: str):
    return any(value in c.split('|') for c in categories)


def is_excluded(value: str):
    return any(value.startswith(pattern) for pattern in excluded_patterns)


def write_file(version: str, result: dict):
    with open(version + '_lang.json', 'w') as output:
        json.dump(result, output)


def parse_lang_json(filename: str, version: str):
    with open(filename) as file:
        content = json.load(file)
        result = {}
        count = {}
        for key in content:
            chunks = key.split(".")
            translation_type = chunks[0]
            if is_categorized(translation_type) and len(chunks) == 3:
                if translation_type not in result:
                    result[translation_type] = []
                translation = '.'.join(chunks[1:]).replace('minecraft_', '')
                if not is_excluded(translation):
                    data = {'translation': translation}
                    arguments = len(re.findall('(%[ds0-9]+)', content[key]))
                    if arguments > 0:
                        data['arguments'] = arguments
                        if translation_type not in count:
                            count[translation_type] = 0
                        count[translation_type] += 1
                    result[translation_type].append(data)
        write_file(version, result)


def parse_lang_file(filename: str, version: str):
    with open(filename) as file:
        lines = file.read().splitlines()
        result = {}
        count = {}
        for line in lines:
            if line == '':
                continue
            translation_key = line.split("=")[0]
            chunks = translation_key.split('.')
            translation_type = chunks[0]
            if chunks[-1] == 'name' and is_categorized(chunks[0]):
                if translation_type not in result:
                    result[translation_type] = []
                translation = '.'.join(chunks[1:])
                if not is_excluded(translation):
                    data = {'translation': translation}
                    arguments = len(re.findall('(%[ds0-9]+)', line.split('=')[1]))
                    if arguments > 0:
                        data['arguments'] = arguments
                        if translation_type not in count:
                            count[translation_type] = 0
                        count[translation_type] += 1
                    result[translation_type].append(data)
        write_file(version, result)


files = ('1_15.json', '1_12.lang')
for file_name in files:
    version = file_name.split(".")[0]
    if file_name.endswith(".json"):  # new lang format
        parse_lang_json(file_name, version)
    elif file_name.endswith('.lang'):  # old lang format
        parse_lang_file(file_name, version)
