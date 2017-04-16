package app.web.dto;


/**
 * Created by Gabriel on 08.04.2017.
 */
public class NavigationButton implements Comparable<NavigationButton> {
    private int pageIndex;
    private String categoryUrl;
    private String name;

    @Override
    public int compareTo(NavigationButton navigationButton) {
        if (navigationButton == null) {
            throw new NullPointerException();
        }
        if (this.equals(navigationButton)) {
            return 0;
        }
        int argumentPageNumber = navigationButton.getPageNumber();
        if (pageIndex <= argumentPageNumber) {
            return -1;
        }
        else {
            return 1;
        }
    }

    @Override
    public String toString() {
        return pageIndex + " " + categoryUrl + " " + name;
    }

    public int getPageNumber() {
        return pageIndex;
    }

    public void setPageNumber(int pageNumber) {
        this.pageIndex = pageNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategoryUrl() {
        return categoryUrl;
    }

    public void setCategoryUrl(String categoryUrl) {
        this.categoryUrl = categoryUrl;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        NavigationButton button = (NavigationButton) o;

        if (pageIndex != button.pageIndex) return false;
        if (categoryUrl != null ? !categoryUrl.equals(button.categoryUrl) : button.categoryUrl != null) return false;
        return name != null ? name.equals(button.name) : button.name == null;
    }

    @Override
    public int hashCode() {
        int result = pageIndex;
        result = 31 * result + (categoryUrl != null ? categoryUrl.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }
}
