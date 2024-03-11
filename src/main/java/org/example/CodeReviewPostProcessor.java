package ltd.clearsolutions.codereviewaiassistant.filters.postprocessing;

import lombok.AllArgsConstructor;
import ltd.clearsolutions.codereviewaiassistant.filters.postprocessing.reviewFilter.ReviewFilter;
import ltd.clearsolutions.codereviewaiassistant.github.model.ReviewedFile;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Component
public class CodeReviewPostProcessor {

    private final List<ReviewFilter> reviewFilters;

    public List<ReviewedFile> filterReviews(List<ReviewedFile> files) {
        List<ReviewedFile> filteredFiles = new ArrayList<>(files);

        for (ReviewFilter filter : reviewFilters) {
            filteredFiles = filter.apply(filteredFiles);
        }
        return filteredFiles;
    }
}
