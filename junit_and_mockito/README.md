# Mockito in Spring MVC

Controller -> ServiceBusinessObject -> DAO -> DB

  - When we write unit tests for Controller, we mock ServiceBusinessObject and write test casses for all public methods inside controller.
  - When we write unit tests for ServiceBusinessObject, we mock DAO and write test casses for all public methods inside ServiceBusinessObject.
  
### Mocking involves

1. Stubbing and set expectations using when, thenReturn, thenThrow etc
2. Verifying that mocked out methods are calle dusing verify, matchers etc

### Resources

Mockito

Blog
http://www.codeproject.com/Articles/516360/Mockito-a-great-mock-framework-for-Java-developmen

Video explanation
http://www.canoo.com/blog/2010/12/15/mockito-screencasts-for-stubbing-verifying-and-argument-matching/comment-page-1/#comment-3197