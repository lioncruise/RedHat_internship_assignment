package org.lioncruise.test;

import static org.junit.Assert.*;

import java.io.IOException;

import javax.servlet.ServletException;
import org.junit.Before;
import org.junit.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

public class HelloWorldServletTest {
    private HelloWorldServlet servlet;
    private MockHttpServletRequest request;
    private MockHttpServletResponse response;

    @Before
    public void setUp() {
        servlet = new HelloWorldServlet();
        request = new MockHttpServletRequest();
        response = new MockHttpServletResponse();
    }

    @Test
    public void testDoGet() throws ServletException, IOException {
        servlet.doGet(request, response);
        assertEquals("hello world", response.getContentAsString());
    }
}