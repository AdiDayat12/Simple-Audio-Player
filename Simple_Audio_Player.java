import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;


public class Simple_Audio_Player {
    public static void main(String[] args) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        //file path, the format of file must be wav
        String filePath = "happy_nation.wav";

        //Create object file from path
        File file = new File("happy_nation.wav");

        //Check if file
        if (!file.isFile()){
            throw new IllegalArgumentException("The path does not point to a valid file: " + filePath);
        }

        //Create audio stream
        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(file);

        //Create clip
        Clip clip = AudioSystem.getClip();
        clip.open(audioInputStream);

        Scanner scanner = new Scanner(System.in);

        String response = "";

        while (!response.equals("Q")){
            System.out.println("P : Play\nS : Stop\nR : Reset\nQ : Quit");
            response = scanner.next();
            response = response.toUpperCase();

            switch (response){
                case "P" :
                    clip.start();
                    break;
                case "S" :
                    clip.stop();
                    break;
                case "R" :
                    clip.setMicrosecondPosition(0);
                    break;
                case "Q" :
                    clip.close();
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}
