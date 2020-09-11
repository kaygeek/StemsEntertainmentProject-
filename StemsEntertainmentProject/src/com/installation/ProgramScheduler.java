package com.installation;

import java.awt.Component;
import java.io.File;
import java.io.IOException;
import java.net.Socket;
import java.nio.file.Files;
import java.util.Timer;
import java.util.TimerTask;
import com.window.dialog.PopupPane;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Kgaugelo
 */
public final class ProgramScheduler
{
    /**
     * Don't let anyone instantiate this class.
     */
    private ProgramScheduler() {}

    private static boolean isRunning;
    private static final String SQL_DRIVER = "mysqld.exe";

    private static final String XAMPP_PATH = "C:\\xampp\\mysql\\bin\\" + SQL_DRIVER;

    private static final String WAMP_64 = searchFile(new File("C:\\wamp64"),
            SQL_DRIVER).getAbsolutePath();

    private static final String WAMP_86 =  searchFile(new File("C:\\wamp86"),
            SQL_DRIVER).getAbsolutePath();

    private static final String WAMP =  searchFile(new File("C:\\wamp"),
            SQL_DRIVER).getAbsolutePath();

    public static boolean startDatabaseServer(Component comp)
    {
        Socket socket = new Socket();
        isRunning = false;
        
        if (Files.exists(Paths.get(XAMPP_PATH))) {
            initiateSocket(socket, XAMPP_PATH, comp);
        }
        else if (Files.exists(Paths.get(WAMP_64))) {
            initiateSocket(socket, WAMP_64, comp);
        }
        else if (Files.exists(Paths.get(WAMP_86))) {
            initiateSocket(socket, WAMP_86, comp);
        }
        else if (Files.exists(Paths.get(WAMP))) {
            initiateSocket(socket, WAMP, comp);
        }
        else
        {
            PopupPane.errDialog(comp, "<html><p>Please download and install</p>"
                            + "<p><b>XAMPP</b> on your computer.</p></html>",
                    "Installation Error");
            System.exit(1);
        }
        return true;
    }

    public static void importDatabase(String username, String password)
    {
        final String DB_PATH = new File("src\\files\\stems_movies.sql").getAbsolutePath();
        final String MYSQL_PATH = "\\xampp\\mysql\\bin";
        final String DB_NAME = "stems_movies";

        String command1 = String.format("cmd.exe /c cd %s & mysql -u %s %s < %s",
                MYSQL_PATH, username, DB_NAME, DB_PATH);

        String command2 = String.format("cmd.exe /c cd %s & mysql -u %s -p%s %s "
                + "< %s", MYSQL_PATH, username, password, DB_NAME, DB_PATH);

        Process process;

        try
        {
            if (password.isEmpty()) {
                process = Runtime.getRuntime().exec(command1);
            }
            else {
                process = Runtime.getRuntime().exec(command2);
            }
            System.out.println(process.toString());
        }
        catch (IOException fileError) {
            System.out.format("%s%n", fileError);
        }
    }

    private static void initiateSocket(Socket socket, String path, Component comp)
    {
        try
        {
            socket = new Socket("127.0.0.1", 3306);
            isRunning = true;
        }
        catch (IOException socketErr)
        {
            try
            {
                Process process = Runtime.getRuntime().exec(path);
                new Timer().schedule(new TimerTask()
                {
                    @Override
                    public void run() {
                        System.out.println("Delay socket for 900 seconds");
                    }
                }, 900);

                socket = new Socket("127.0.0.1", 3306);
                isRunning = true;

                System.out.format("%s=%s%nServer status=%s%nerror rate=%s%n",
                        "Process", process.getErrorStream(), isRunning, socketErr);
            }
            catch (IOException fileError)
            {
                if (isRunning) {
                    PopupPane.errDialog(comp, serverResponseError(), "MYSQL ERROR");
                }
                System.out.format("%n%n%s%n%n", fileError);
            }
        }
        finally
        {
            try
            {
                assert socket != null;
                socket.close();
            }
            catch (Exception socketErr) {
                System.out.format("%s", socketErr);
            }
        }
    }

    /**
     * Use a divide and conquer approach to recursively search
     * for the specified file within subdirectories
     *
     * @param rootDir The root folder name
     * @param fileName The specified file name to search for
     * @return The absolute path containing the file
     * @author Tom
     * @see <a href="https://stackoverflow.com/questions/10780747/recursively-search-for-a-directory-in-java"/a>
     */
    private static File searchFile(File rootDir, String fileName)
    {
        try
        {
            File[] files = rootDir.listFiles();
            List<File> directories = new ArrayList<>(files.length);

            for (File file : files)
            {
                if (file.getName().equals(fileName)) {
                    return file;
                }
                else if (file.isDirectory()) {
                    directories.add(file);
                }
            }

            for (File directory : directories)
            {
                File file = searchFile(directory, fileName);               
                if (file != null) {
                    return file;
                }
            }
            return new File("C:\\");
        }
        catch (NullPointerException nullPointer)
        {
            System.out.printf("%n%s%n", nullPointer);
            return new File("C:\\");
        }
    }

    private static String serverResponseError()
    {
        return "<html><p>Run <b>Task Manager</> and terminate the following programs:</p>"
                + "<ol><li><b>Skype</b></li><li><b>mysql.exe</b></li>"
                + "<li><b>Java Update Scheduler</b></li>"
                + "<li><b>XAMPP Control Panel or WAMPSERVER</b></li>"
                + "</ol><p>Then restart the application.</p></html>";
    }
}