package com.shop.batchprocessing;

import com.shop.model.Category;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;

public class CategoryItemProcessor implements ItemProcessor<Category, Category> {

    private static final Logger log = LoggerFactory.getLogger(CategoryItemProcessor.class);

    @Override
    public Category process(final Category category) throws Exception {
        final String name = category.getName().toUpperCase();
        final String description = category.getDescription().toUpperCase();

        final Category transformedCategory = new Category(name,description);

        log.info("Converting (" + category + ") into (" + transformedCategory + ")");

        return transformedCategory;
    }

}