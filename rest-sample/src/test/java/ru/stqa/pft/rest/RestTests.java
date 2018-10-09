package ru.stqa.pft.rest;

import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Set;

import static org.testng.Assert.assertEquals;

public class RestTests extends TestBase{

  @Test
  public void testCreateIssue() throws IOException {
    skipIfNotFixed(341);
    Set<Issue> oldIssues = getIssues();
    Issue newIssue = new Issue().withSubject("Test issue").withDescription("New test issue");
    int issueId = createIssue(newIssue);
    Set<Issue> newIssues = getIssues();
      oldIssues.add(newIssue.withId(issueId));
    assertEquals(newIssues, oldIssues);
  }

  /*public int limit() throws IOException {
    String json = getExecutor().execute(Request.Get("http://bugify.stqa.ru/api/issues.json"))
            .returnContent().asString();
   return new JsonParser().parse(json).getAsJsonObject().get("limit").getAsInt();
     }
*/



}
