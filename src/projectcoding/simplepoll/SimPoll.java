package projectcoding.simplepoll;

import projectcoding.simplepoll.simpoll.Poll;

public class SimPoll {
    private static final java.util.Scanner scanner = new java.util.Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("Welcome to SimPoll!");
        Poll poll = new Poll();
        
        setUpPoll(poll);
        startPoll(poll);
        showPollResult(poll);

        scanner.close();
    }

    private static void setUpPoll(Poll poll) {
        System.out.print("\nPoll question: ");
        poll.setQuestion(scanner.nextLine().trim());

        System.out.println("Choices: (min. 2) ");
        
        for(int i = 0; i < 2; i++) {
            System.out.print("New choice: ");
            poll.addChoice(scanner.nextLine().trim(), i);
        }

        System.out.print("\nMaximum votes: ");
        poll.setMaxVotes(scanner.nextInt());
        scanner.nextLine();
    }

    private static void startPoll(Poll poll) {
        System.out.println("\nThe question: " + poll.getQuestion());
        
        String vote;
        while(poll.getCurrentVotes() < poll.getMaxVotes()){
            System.out.println("\nYou currently have " + poll.getChoicesCount() + " choices: ");

            for(int i = 0; i < poll.getChoicesCount(); i++) {
                System.out.println(poll.getChoices()[i] + " : " + poll.getVotes()[i]);
            }

            System.out.print("Enter your vote: ");
            vote = scanner.nextLine().trim();
             
            poll.addChoice(vote);
            
            poll.addCurrentVotes();
        }
    }

    private static void showPollResult(Poll poll) {

        System.out.println("\nPOLL RESULTS:");
        for(int i = 0; i < poll.getChoicesCount(); i++) {
            System.out.println(poll.getChoices()[i] + " : " + poll.getVotes()[i]);
        }

        System.out.println("People picked: " + poll.getChoices()[poll.getLead()]);
    }
}