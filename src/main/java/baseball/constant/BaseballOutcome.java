package baseball.constant;

public enum BaseballOutcome {
    STRIKE("스트라이크", "strike"),
    BALL("볼", "ball"),
    NOTHING("낫싱", "nothing");

    private final String koreanName;
    private final String englishName;

    BaseballOutcome(String koreanName, String englishName) {
        this.koreanName = koreanName;
        this.englishName = englishName;
    }

    public String getKoreanName() {
        return koreanName;
    }

    public String getEnglishName() {
        return englishName;
    }
}
