package projectcoding.simplepoll.simpoll;

import java.util.Arrays;

public class Poll {
    private String question = "";
    private String[] choices = new String[2];
    private int[] votes = new int[2];
    private int choicesCount = 0;
    private int currentVotes = 0;
    private int maxVotes;
    private int lead = -1;

    public String getQuestion() {
        return this.question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String[] getChoices() {
        return this.choices;
    }

    public void addChoice(String newChoice, int idx) {
        this.choices[idx] = newChoice;
    }

    public void addChoice(String newChoice) {
        if (this.hasChoice(newChoice)) {
            this.votes[Arrays.binarySearch(this.choices, newChoice)]++;
        } else {
            this.choices = Poll.arrAppend(this.choices, newChoice);
            this.votes = Poll.arrAppend(this.votes, 1);
        }
    }

    public int[] getVotes() {
        return this.votes;
    }

    private boolean hasChoice(String newChoice) {
        return Arrays.binarySearch(this.choices, newChoice) >= 0;
    }

    private static String[] arrAppend(String[] arr, String choice) {
        String[] newArr = Arrays.copyOf(arr, arr.length+1);
        newArr[arr.length] = choice;
        return newArr;
    }

    private static int[] arrAppend(int[] arr, int choice) {
        int[] newArr = Arrays.copyOf(arr, arr.length+1);
        newArr[arr.length] = choice;
        return newArr;
    } 

    public void setChoicesCount() {
        this.choicesCount = this.choices.length;
    }

    public int getChoicesCount() {
        setChoicesCount();
        return this.choicesCount;
    }

    public int getCurrentVotes() {
        return this.currentVotes;
    }

    public void addCurrentVotes() {
        this.currentVotes++;
    }

    public int getMaxVotes() {
        return this.maxVotes;
    }

    public void setMaxVotes(int maxVotes) {
        this.maxVotes = maxVotes;
    }

    public int getLead() {
        this.setLead();
        return this.lead;
    }

    public void setLead() {
        for(int i = 0; i < votes.length; i++) {
            if (this.lead < this.votes[i]) {
                this.lead = i;
            }
        }
    }
}
