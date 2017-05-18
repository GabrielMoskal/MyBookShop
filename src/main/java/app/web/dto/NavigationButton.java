package app.web.dto;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * Created by Gabriel on 08.04.2017.
 */
@Getter
@ToString
@EqualsAndHashCode
public class NavigationButton implements Comparable<NavigationButton> {
    @Min(0)
    private int pageIndex;
    @NotNull
    private String categoryUrl;
    @NotNull
    private String name;

    public NavigationButton(int pageIndex, final String categoryUrl, final String name) {
        this.pageIndex = pageIndex;
        this.categoryUrl = categoryUrl;
        this.name = name;
    }

    @Override
    public int compareTo(@javax.annotation.Nonnull NavigationButton navigationButton) {
        return Integer.compare(pageIndex, navigationButton.getPageIndex());
    }
}
