# Flattifier (Flattening-Unifier)
Flattifier is a script that unifies translation keys between files (pre-flattening and post-flattening).
           
Since the translation identifiers between versions 1.12 and 1.13 have been changed, it is difficult to put them together in one piece.
           
The purpose of this script is to create two JSON files and compare the results between the two and potentially extract similarities.

In the future, the script will match the plugin and offer compatibility with pre-flattening versions (1.8 up to 1.12) thanks to a utility class that will fetch the information from the generated JSON files.

## What is flattening ?
Take a look to https://minecraft.gamepedia.com/Java_Edition_1.13/Flattening

## Usage

``python extract.py``

**NOTE** : The script was coded in **Python 3**.
