class Periodical extends Item {
    private int issueNum;

    public Periodical() {
        super();
        this.issueNum = 0;
    }

    public Periodical(String title, int issueNum) {
        super(title);
        this.issueNum = issueNum;
    }

    public int getIssueNum() {
        return issueNum;
    }

    public void setIssueNum(int issueNum) {
        this.issueNum = issueNum;
    }

    @Override
    public String getListing() {
        return "Periodical Title - " + getTitle() + "\nIssue # - " + issueNum;
    }
}
