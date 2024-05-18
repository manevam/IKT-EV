package com.ikt.event.management;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ikt.event.management.entity.Company;
import com.ikt.event.management.repository.CompanyRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@AutoConfigureMockMvc
public class CompanyControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private CompanyRepository companyRepository;

    @BeforeEach
    public void setup() {
        
    }

    @Test
    public void testCreateCompany() throws Exception {
        CompanyRepository requestDto = new CompanyRepository() {
            @Override
            public Optional<Company> findByName(String name) {
                return Optional.empty();
            }

            @Override
            public Optional<Company> findById(Long id) {
                return Optional.empty();
            }

            @Override
            public void setName(String test_company) {

            }

            @Override
            public void setEmail(String s) {

            }

            @Override
            public void flush() {

            }

            @Override
            public <S extends Company> S saveAndFlush(S entity) {
                return null;
            }

            @Override
            public <S extends Company> List<S> saveAllAndFlush(Iterable<S> entities) {
                return null;
            }

            @Override
            public void deleteAllInBatch(Iterable<Company> entities) {

            }

            @Override
            public void deleteAllByIdInBatch(Iterable<Long> longs) {

            }

            @Override
            public void deleteAllInBatch() {

            }

            @Override
            public Company getOne(Long aLong) {
                return null;
            }

            @Override
            public Company getById(Long aLong) {
                return null;
            }

            @Override
            public Company getReferenceById(Long aLong) {
                return null;
            }

            @Override
            public <S extends Company> List<S> findAll(Example<S> example) {
                return null;
            }

            @Override
            public <S extends Company> List<S> findAll(Example<S> example, Sort sort) {
                return null;
            }

            @Override
            public <S extends Company> List<S> saveAll(Iterable<S> entities) {
                return null;
            }

            @Override
            public List<Company> findAll() {
                return null;
            }

            @Override
            public List<Company> findAllById(Iterable<Long> longs) {
                return null;
            }

            @Override
            public <S extends Company> S save(S entity) {
                return null;
            }

            @Override
            public boolean existsById(Long aLong) {
                return false;
            }

            @Override
            public long count() {
                return 0;
            }

            @Override
            public void deleteById(Long aLong) {

            }

            @Override
            public void delete(Company entity) {

            }

            @Override
            public void deleteAllById(Iterable<? extends Long> longs) {

            }

            @Override
            public void deleteAll(Iterable<? extends Company> entities) {

            }

            @Override
            public void deleteAll() {

            }

            @Override
            public List<Company> findAll(Sort sort) {
                return null;
            }

            @Override
            public Page<Company> findAll(Pageable pageable) {
                return null;
            }

            @Override
            public <S extends Company> Optional<S> findOne(Example<S> example) {
                return Optional.empty();
            }

            @Override
            public <S extends Company> Page<S> findAll(Example<S> example, Pageable pageable) {
                return null;
            }

            @Override
            public <S extends Company> long count(Example<S> example) {
                return 0;
            }

            @Override
            public <S extends Company> boolean exists(Example<S> example) {
                return false;
            }

            @Override
            public <S extends Company, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
                return null;
            }
        };
        requestDto.setName("Test Company");
        requestDto.setEmail("test@test.com");

        // Perform the POST request
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/mgmt/companies/create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(requestDto)))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();

        // Verify the response
        String responseContent = result.getResponse().getContentAsString();
        Company createdCompany = new ObjectMapper().readValue(responseContent, Company.class);

        assertEquals("Test Company", createdCompany.getName());
        assertEquals("test@test.com", createdCompany.getEmail());


    }


}



