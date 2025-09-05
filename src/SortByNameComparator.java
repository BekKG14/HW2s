import search.Searchable;

import java.util.Comparator;

public class SortByNameComparator implements Comparator<Searchable> {

    @Override
    public int compare(Searchable s1, Searchable s2) {
        int result = Integer.compare(s2.getSearchTerm().length(), s1.getSearchTerm().length());
        if (result != 0) {
            return result;
        }else {
            return s1.getSearchTerm().compareTo(s2.getSearchTerm());
        }
    }

}
