package ma.youcode.clicktrack.model;

public class Link {
    private int id;
    private String offre;
    private String urlDestination;
    private int clicks;
    private Publisher publisher;

    public Link(String offre, String urlDestination, int clicks, Publisher publisher) {
        this.offre = offre;
        this.urlDestination = urlDestination;
        this.clicks = clicks;
        this.publisher = publisher;
    }

    public Link(int id, String offre, String urlDestination, int clicks, Publisher publisher) {
        this.id = id;
        this.offre = offre;
        this.urlDestination = urlDestination;
        this.clicks = clicks;
        this.publisher = publisher;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOffre() {
        return offre;
    }

    public void setOffre(String offre) {
        this.offre = offre;
    }

    public String getUrlDestination() {
        return urlDestination;
    }

    public void setUrlDestination(String urlDestination) {
        this.urlDestination = urlDestination;
    }

    public int getClicks() {
        return clicks;
    }

    public void setClicks(int clicks) {
        this.clicks = clicks;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }
}
