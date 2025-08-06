import search.Searchable;

public class SearchEngine {
    private Searchable[] searchables;

    public SearchEngine(int capacity) {
        this.searchables = new Searchable[capacity];
    }

    public void add(Searchable item) {
        for (int i = 0; i < this.searchables.length; ++i) {
            if (this.searchables[i] == null) {
                this.searchables[i] = item;
                return;
            }
        }

        System.out.println("Места нет");
    }

    public Searchable[] search(String searchTerm) {
        Searchable[] result = new Searchable[5];
        int i = 0;

        for (int size = 0; i < this.searchables.length; ++i) {
            if (this.searchables[i] != null && this.searchables[i].getSearchTerm().contains(searchTerm)) {
                result[size++] = this.searchables[i];
                if (size >= 5) {
                    break;
                }
            }
        }

        return result;
    }

    public Searchable searchBestResult(String substring) throws BestResultNotFound {

        int currentObject = 0;
        Searchable[] arr = search(substring);
        int bestResult = -1;

        for (int i = 0; i < arr.length; i++) {
            int match = 0;
            int startIndex = 0;
            if (arr[i] == null) {
                continue;
            }
            while (true) {
                int foundAt = arr[i].getSearchTerm().indexOf(substring, startIndex);
                if (foundAt != -1) {
                    match++;
                    startIndex = foundAt + substring.length();
                } else {
                    break;
                }
            }

            if (match > bestResult) {
                bestResult = match;
                currentObject = i;
            }
        }
        if (arr[currentObject] != null) {
            return arr[currentObject];
        } else {
            throw new BestResultNotFound("Нет подходящих по запросу ");
        }
    }
}