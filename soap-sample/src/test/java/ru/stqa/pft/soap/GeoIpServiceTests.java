package ru.stqa.pft.soap;

import com.lavasoft.GeoIPService;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class GeoIpServiceTests {

  @Test
  public void testMyIp(){
    String geoIp = new GeoIPService().getGeoIPServiceSoap12().getIpLocation("5.167.101.120");
    assertEquals(geoIp, "<GeoIP><Country>RU</Country><State>77</State></GeoIP>");
  }

  @Test
  public void testInvalidIp(){
    String geoIp = new GeoIPService().getGeoIPServiceSoap12().getIpLocation("5.167.asd.ppp");
    assertEquals(geoIp, "<GeoIP><Country>RU</Country><State>77</State></GeoIP>");
  }
}
