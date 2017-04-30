package app.web.dto;


import lombok.Getter;
import lombok.ToString;

/**
 * Created by Gabriel on 08.04.2017.
 */
@Getter
@ToString
public class NavigationButton implements Comparable<NavigationButton> {
    private int pageIndex;
    private String categoryUrl;
    private String name;

    public NavigationButton(int pageIndex, final String categoryUrl, final String name) {
        this.pageIndex = pageIndex;
        this.categoryUrl = categoryUrl;
        this.name = name;
    }

    @Override
    public int compareTo(final NavigationButton navigationButton) {
        if (navigationButton == null) {
            throw new NullPointerException("Null argument in NavigationButton.compareTo function");
        }
        return Integer.compare(pageIndex, navigationButton.getPageIndex());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        NavigationButton button = (NavigationButton) o;

        return pageIndex == button.pageIndex;
    }

    @Override
    public int hashCode() {
        return pageIndex;
    }
}
