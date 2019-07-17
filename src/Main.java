import java.io.*;

public class Main {

    public static void main(String [] args)
    {
        String fileRead="InputFile.txt";
        String fileWrite="OutputFile.txt";

        try {
            FileReader fileReader = new FileReader(fileRead);
            BufferedReader br = new BufferedReader(fileReader);

            FileWriter fileWriter = new FileWriter(fileWrite);
            BufferedWriter bw = new BufferedWriter(fileWriter);

            String line=br.readLine();
            while (line!=null)
            {
                if(line.contains("//")) {
                    String word[] = line.split("//");
                    if (word[0].trim().length() > 0) {
                        bw.write(word[0]);
                        bw.newLine();
                    }
                }
                else if(line.contains("/*"))
                {
                    String word[] = line.split("/*");
                    if (word[0].trim().length() > 0) {
                        bw.write(word[0]);
                        bw.newLine();
                    }
                    while (!line.contains("*/"))
                        line=br.readLine();
                    String temp[]=line.split("\\*/");
                    if(temp.length>1)
                        if (word[0].trim().length() > 0) {
                            bw.write(word[0]);
                            bw.newLine();
                        }
                }
                else
                if (line.trim().length() > 0) {
                    bw.write(line);
                    bw.newLine();
                }
                line=br.readLine();
            }
            br.close();
            bw.close();
        }
        catch (FileNotFoundException exception)
        {
            System.out.println("ERROR : File Not Found or File Name Incorrect");
        }
        catch (IOException exception)
        {
            System.out.println("ERROR : Unable to Write in File");
        }
    }
}
