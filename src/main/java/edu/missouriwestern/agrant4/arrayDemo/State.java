package edu.missouriwestern.agrant4.arrayDemo;

/**
 * This class represents a single state object.
 */

public class State {

    /* --- DATA --- */
    private String state,slug,code,nickname,website,
            admission_date,admission_number,capital_city,
            capital_url,population,population_rank,constitution_url,
            state_flag_url,state_seal_url,map_image_url,
            landscape_background_url, skyline_background_url,
            twitter_url, facebook_url;

    /* --- TO STRING --- */
    @Override
    public String toString() {
        return "State{" +
                "state='" + state + '\'' +
                ", slug='" + slug + '\'' +
                ", code='" + code + '\'' +
                ", nickname='" + nickname + '\'' +
                ", website='" + website + '\'' +
                ", admission_date='" + admission_date + '\'' +
                ", admission_number='" + admission_number + '\'' +
                ", capital_city='" + capital_city + '\'' +
                ", capital_url='" + capital_url + '\'' +
                ", population='" + population + '\'' +
                ", population_rank='" + population_rank + '\'' +
                ", constitution_url='" + constitution_url + '\'' +
                ", state_flag_url='" + state_flag_url + '\'' +
                ", state_seal_url='" + state_seal_url + '\'' +
                ", map_image_url='" + map_image_url + '\'' +
                ", landscape_background_url='" + landscape_background_url + '\'' +
                ", skyline_background_url='" + skyline_background_url + '\'' +
                ", twitter_url='" + twitter_url + '\'' +
                ", facebook_url='" + facebook_url + '\'' +
                '}';
    } //End of toString.

    /* --- GETTERS & SETTERS --- */
    public String getState() {
        return state;
    }
    public void setState(String state) {
        this.state = state;
    }
    public String getSlug() {
        return slug;
    }
    public void setSlug(String slug) {
        this.slug = slug;
    }
    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }
    public String getNickname() {
        return nickname;
    }
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
    public String getWebsite() {
        return website;
    }
    public void setWebsite(String website) {
        this.website = website;
    }
    public String getAdmission_date() {
        return admission_date;
    }
    public void setAdmission_date(String admission_date) {
        this.admission_date = admission_date;
    }
    public String getAdmission_number() {
        return admission_number;
    }
    public void setAdmission_number(String admission_number) {
        this.admission_number = admission_number;
    }
    public String getCapital_city() {
        return capital_city;
    }
    public void setCapital_city(String capital_city) {
        this.capital_city = capital_city;
    }
    public String getCapital_url() {
        return capital_url;
    }
    public void setCapital_url(String capital_url) {
        this.capital_url = capital_url;
    }
    public String getPopulation() {
        return population;
    }
    public void setPopulation(String population) {
        this.population = population;
    }
    public String getPopulation_rank() {
        return population_rank;
    }
    public void setPopulation_rank(String population_rank) {
        this.population_rank = population_rank;
    }
    public String getConstitution_url() {
        return constitution_url;
    }
    public void setConstitution_url(String constitution_url) {
        this.constitution_url = constitution_url;
    }
    public String getState_flag_url() {
        return state_flag_url;
    }
    public void setState_flag_url(String state_flag_url) {
        this.state_flag_url = state_flag_url;
    }
    public String getState_seal_url() {
        return state_seal_url;
    }
    public void setState_seal_url(String state_seal_url) {
        this.state_seal_url = state_seal_url;
    }
    public String getMap_image_url() {
        return map_image_url;
    }
    public void setMap_image_url(String map_image_url) {
        this.map_image_url = map_image_url;
    }
    public String getLandscape_background_url() {
        return landscape_background_url;
    }
    public void setLandscape_background_url(String landscape_background_url) {
        this.landscape_background_url = landscape_background_url;
    }
    public String getSkyline_background_url() {
        return skyline_background_url;
    }
    public void setSkyline_background_url(String skyline_background_url) {
        this.skyline_background_url = skyline_background_url;
    }
    public String getTwitter_url() {
        return twitter_url;
    }
    public void setTwitter_url(String twitter_url) {
        this.twitter_url = twitter_url;
    }
    public String getFacebook_url() {
        return facebook_url;
    }
    public void setFacebook_url(String facebook_url) {
        this.facebook_url = facebook_url;
    }
} //End of State class.
