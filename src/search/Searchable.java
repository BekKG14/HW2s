package search;

public interface Searchable {
    String getSearchTerm();

    String getSearchType();

    default String getStringRepresentation(){
        return getSearchTerm() + " " + getSearchType();
    };



}
