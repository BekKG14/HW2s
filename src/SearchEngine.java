import product.Product;
import search.Searchable;

import java.util.*;

public class SearchEngine<P extends Searchable> {
    private Set<Searchable> searchables;

    public SearchEngine() {
        this.searchables = new HashSet<>();
    }

    public void add(Searchable item) {
        searchables.add(item);
        }

    public Set<Searchable> search(String searchTerm) {
        Set<Searchable> result = new TreeSet<>(new SortByName());
        for (Searchable searchable : searchables) {
            if (searchable.getSearchTerm().contains(searchTerm)) {
                result.add(searchable);
            }
        }
        return result;
    }

    public Searchable searchBestResult(String substring) throws BestResultNotFound {
        Set<Searchable> values = search(substring);
        int bestResult = -1;
        Searchable lol = null;
        if (values.isEmpty()){
            throw new BestResultNotFound("Нет подходящих по запросу ");
        }
        for (Searchable result : values) {
            int match = 0;
            int startIndex = 0;
            if (result == null) {
                continue;
            }
            while (true) {
                int foundAt = result.getSearchTerm().indexOf(substring, startIndex);
                if (foundAt != -1) {
                    match++;
                    startIndex = foundAt + substring.length();
                } else {
                    break;
                }
            }if (match > bestResult) {
                bestResult = match;
                lol = result;
            }
        }return lol;
    }
}