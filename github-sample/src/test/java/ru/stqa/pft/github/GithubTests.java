package ru.stqa.pft.github;

import com.google.common.collect.ImmutableMap;
import com.jcabi.github.*;
import org.testng.annotations.Test;

import java.io.IOException;

public class GithubTests {

  @Test
  public void testCommits() throws IOException {
    Github github = new RtGithub("9f293a186c2be3bc90ae4bf9118317e9fa8b22a3");
    RepoCommits commits = github.repos().get(new Coordinates.Simple("ilinav", "java_test"))
            .commits();
    for (RepoCommit commit : commits.iterate(new ImmutableMap.Builder<String, String>().build())) {
      //System.out.println(commit);
      System.out.println(new RepoCommit.Smart(commit).message());
    }
  }
}
