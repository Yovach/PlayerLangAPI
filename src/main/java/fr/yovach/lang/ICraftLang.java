package fr.yovach.lang;

public interface ICraftLang<T> {

    public String getTranslation();

    public String getTranslation(final String version);

    public T get();

}
