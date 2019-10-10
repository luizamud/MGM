package luizfelipemoralez.amuds.mygymmanager;

public class Owner {
    private String god_name;
    private String god_job;
    private String god_email;
    private String god_bio;

    public Owner(String god_name, String god_job, String god_email, String god_bio) {
        this.god_name = god_name;
        this.god_job = god_job;
        this.god_email = god_email;
        this.god_bio = god_bio;
    }

    public String getGod_name() {
        return god_name;
    }

    public void setGod_name(String god_name) {
        this.god_name = god_name;
    }

    public String getGod_job() {
        return god_job;
    }

    public void setGod_job(String god_job) {
        this.god_job = god_job;
    }

    public String getGod_email() {
        return god_email;
    }

    public void setGod_email(String god_email) {
        this.god_email = god_email;
    }

    public String getGod_bio() {
        return god_bio;
    }

    public void setGod_bio(String god_bio) {
        this.god_bio = god_bio;
    }

}
