import product.Product;
import search.Searchable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SearchEngine<P extends Searchable> {
    private ArrayList<P> searchables;

    public SearchEngine() {
        this.searchables = new ArrayList<>();
    }

    public void add(P item) {
        searchables.add(item);
        }

    public Map<String, P> search(String searchTerm) {
        Map<String, P> result = new HashMap<>();
        for (P searchable : searchables) {
            if (searchable.getSearchTerm().contains(searchTerm)) {
                result.put(searchable.getSearchTerm(), searchable);
            }
        }
        return result;
    }

    public Searchable searchBestResult(String substring) throws BestResultNotFound {
        int currentObject = 0;
        Map<String, P> values = search(substring);
        ArrayList<P> arr = new ArrayList<>();
        arr.addAll(values.values());
        int bestResult = -1;

        for (int i = 0; i < arr.size(); i++) {
            int match = 0;
            int startIndex = 0;
            if (arr.get(i) == null) {
                continue;
            }
            while (true) {
                int foundAt = arr.get(i).getSearchTerm().indexOf(substring, startIndex);
                if (foundAt != -1) {
                    match++;
                    startIndex = foundAt + substring.length();
                } else {
                    break;
                }
            }if (match > bestResult) {
                bestResult = match;
                currentObject = i;
            }
        }if (arr.get(currentObject) != null) {
            return arr.get(currentObject);
        }else {
            throw new BestResultNotFound("Нет подходящих по запросу ");
        }
    }
}