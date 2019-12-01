//package com.shop.batchprocessing;
//
//import com.shop.model.Category;
//import org.springframework.batch.core.Job;
//import org.springframework.batch.core.Step;
//import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
//import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
//import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
//import org.springframework.batch.core.launch.support.RunIdIncrementer;
//import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
//import org.springframework.batch.item.database.JdbcBatchItemWriter;
//import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder;
//import org.springframework.batch.item.file.FlatFileItemReader;
//import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
//import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.io.ClassPathResource;
//
//import javax.sql.DataSource;
//
//@Configuration
//@EnableBatchProcessing
//public class BatchConfiguration {
//
//    @Autowired
//    public JobBuilderFactory jobBuilderFactory;
//
//    @Autowired
//    public StepBuilderFactory stepBuilderFactory;
//
////    @Bean
////    public FlatFileItemReader<Category> reader() {
////        return new FlatFileItemReaderBuilder<Category>()
////                .name("personItemReader")
////                .resource(new ClassPathResource("sample-data.csv"))
////                .delimited()
////                .names(new String[]{"description", "name"})
////                .fieldSetMapper(new BeanWrapperFieldSetMapper<Category>() {{
////                    setTargetType(Category.class);
////                }})
////                .build();
////    }
//
//    @Bean
//    public CategoryItemProcessor processor() {
//        return new CategoryItemProcessor();
//    }
//
////    @Bean
////    public JdbcBatchItemWriter<Category> writer(DataSource dataSource) {
////        return new JdbcBatchItemWriterBuilder<Category>()
////                .itemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>())
////                .sql("INSERT INTO people (first_name, last_name) VALUES (:firstName, :lastName)")
////                .dataSource(dataSource)
////                .build();
////    }
//
//    @Bean
//    public Job importUserJob(JobCompletionNotificationListener listener, Step step1) {
//        return jobBuilderFactory.get("importUserJob")
//                .incrementer(new RunIdIncrementer())
//                .listener(listener)
//                .flow(step1)
//                .end()
//                .build();
//    }
//
//    @Bean
//    public Step step1(JdbcBatchItemWriter<Category> writer) {
//        return stepBuilderFactory.get("step1")
//                .<Category, Category> chunk(10)
////                .reader(reader())
//                .processor(processor())
//                .writer(writer)
//                .build();
//    }
//
//}