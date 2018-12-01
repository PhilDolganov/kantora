package com.javafortesters.chap019files;

import org.junit.Test;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

import static java.nio.file.StandardCopyOption.ATOMIC_MOVE;
import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;
import static junit.framework.TestCase.assertTrue;
import static junit.framework.TestCase.format;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;

public class Class19Examples {
    private File writeTheTestDataFile() throws IOException {
        File outputFile = File.createTempFile("forReading", null);
        PrintWriter print = new PrintWriter(new BufferedWriter(new FileWriter(outputFile)));
        for (int lineNumber = 1; lineNumber < 6; lineNumber++) {
            print.println("line " + lineNumber);
        }
        print.close();
        return outputFile;
    }

    @Test
    public void outputFileToSystemOutWithBufferedReader() throws IOException {

        File inputFile = writeTheTestDataFile();
        BufferedReader reader = new BufferedReader(new FileReader(inputFile));

        try {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } finally {
            reader.close();
        }
    }

    @Test
    public void createTempFile() throws IOException {
        File outputFile = File.createTempFile("forReading", null);

        File aTempFile = File.createTempFile("pre", null, new File(System.getProperty("user.dir")));

    }

    @Test
    public void createTempFileVaryTheParameters() throws IOException {
        // on Windows these files are in %TEMP%
        // on Mac these files are in $TMPDIR
        File temp1 = File.createTempFile("temp1", null);
        File temp2 = File.createTempFile("temp2OutFile", ".out");

        assertThat(temp1.exists(), is(true));
        assertThat(temp2.exists(), is(true));

        temp1.deleteOnExit();
        temp2.deleteOnExit();
    }

    @Test
    public void separatorAndPathSeparator() {
        assertTrue("Unrecognised OS file separator",
                File.separator.equals("\\") ||
                        File.separator.equals("/"));
        assertTrue("Unrecognised OS path separator",
                File.pathSeparator.equals(";") ||
                        File.pathSeparator.equals(":"));
    }

    @Test
    public void writeOutTheFileListRoots() {
        File[] roots = File.listRoots();
        assertTrue(roots.length > 0);

        for (File aFile : roots) {
            System.out.println(aFile.getAbsolutePath());
        }
    }

    @Test
    public void aNewFileDoesNotCreateAFile() throws IOException {
        File aTempFile = new File("c:/tempJavaForTesters.txt");
        assertThat(aTempFile.exists(), is(false));
    }

    @Test
    public void createAFileAndDeleteIt() throws IOException {
        File aTempFile = new File("C:/Users/phild_000/tempJavaForTesters.txt");
        assertThat(aTempFile.exists(), is(false));

        aTempFile.createNewFile();
        assertThat(aTempFile.exists(), is(true));

        aTempFile.delete();
        assertThat(aTempFile.exists(), is(false));

        File aTempFile1 = Paths.get("C:/Users/phild_000/", "tempJavaForTesters.txt").toFile();
    }

    @Test
    public void createATemporaryFileWithCustomCode() throws IOException {
        String directory = System.getProperty("java.io.tmpdir");
        String fileName = "prefix" + System.currentTimeMillis() + ".tmp";

        File aTempFile = new File(directory, fileName);
        assertThat(aTempFile.exists(), is(false));

        aTempFile.createNewFile();
        assertThat(aTempFile.exists(), is(true));

        aTempFile.delete();
        assertThat(aTempFile.exists(), is(false));
    }

    @Test
    public void pathsGetAndPathToCreate() {
        String tempDir = System.getProperty("java.io.tmpdir");
        File aTempFile = new File(tempDir, "tempJavaForTesters.txt");

        String tempDirectory = System.getProperty("java.io.tmpdir");
        File aFile = new File(tempDirectory);
        aFile = new File(aFile, "1");
        aFile = new File(aFile, "2");
        aFile = new File(aFile, "3");
        aFile = new File(aFile, "4");

        Path aPath = Paths.get(tempDirectory, "1", "2", "3", "4");

        assertEquals(aFile.getAbsolutePath(), aPath.toFile().getAbsolutePath());

        String tempDir2 = System.getProperty("java.io.tmpdir");
        File aTempFile2 = Paths.get(tempDir2, "tempJavaForTesters2.txt").toFile();

    }

    @Test
    public void deleteOnExit() throws IOException {
        File aTempFile = File.createTempFile("prefix", "suffix");
        assertThat(aTempFile.getName().startsWith("prefix"), is(true));
        assertThat(aTempFile.getName().endsWith("suffix"), is(true));

        assertTrue(System.getProperty("java.io.tmpdir").startsWith(aTempFile.getParent()));
        assertThat(aTempFile.getAbsolutePath().endsWith("suffix"), is(true));
        assertThat(aTempFile.getAbsolutePath().startsWith(System.getProperty("java.io.tmpdir")), is(true));

        assertThat(aTempFile.getCanonicalPath().endsWith("suffix"), is(true));
        assertThat(aTempFile.getCanonicalPath().contains(System.getProperty("java.io.tmpdir")), is(false)); // asserts false, but in book shows as true

        aTempFile.deleteOnExit();
    }

    @Test
    public void writeATestToCheckCanonicalConversion() throws IOException {
        File absolute1 = new File("C:/1/2/3/4/../../..");
        File absolute2 = new File("C:/1/2/../../1");
        File canonical = new File("C:/1");

        assertThat(trimOsStuff(canonical.getAbsolutePath()), is(trimOsStuff(canonical.getCanonicalPath())));
        assertThat(trimOsStuff(canonical.getAbsolutePath()), is(trimOsStuff(absolute1.getCanonicalPath())));
        assertThat(trimOsStuff(canonical.getAbsolutePath()), is(trimOsStuff(absolute2.getCanonicalPath())));
        assertThat(absolute1.getAbsolutePath().contains(".."), is(true));
        assertThat(absolute2.getAbsolutePath().contains(".."), is(true));
    }
    // The above code runs fine on a Mac and Windows without needing trimOsStuff but on Linux, it seems to add a ./
    // in the middle of the absolute path e.g /home/travis/build/eviltester/javaForTestersCode/./source/C:/1
    // So I add the following method to trim out the operating system addition to the path e.g. anything before the C:


    private String trimOsStuff(String absolutePath) {
        int posOfDrive = absolutePath.indexOf("C:");
        String pathWithoutOsPrefixes = absolutePath.substring(posOfDrive);
        System.out.println(String.format("trimOsStuff: %s became %s", absolutePath, pathWithoutOsPrefixes));
        return pathWithoutOsPrefixes;
    }

    @Test
    public void mkdirAndMkdirs() {
        String tempDirectory = System.getProperty("java.io.tmpdir");

        File aDirectory = Paths.get(tempDirectory, Long.toString(System.currentTimeMillis()),
                Long.toString(System.currentTimeMillis())).toFile();

        assertThat(aDirectory.mkdir(), is(false));
        assertThat(aDirectory.mkdirs(), is(true));
    }

    @Test
    public void checkThatTheTempDirectoryIsADirectory() {
        File tempDir = new File(System.getProperty("java.io.tmpdir"));

        assertThat(tempDir.isDirectory(), is(true));
        assertThat(tempDir.isFile(), is(false));
    }

    @Test
    public void writingTestFiles() throws IOException {
        File outputFile = File.createTempFile("printWriter", null);
        FileWriter writer = new FileWriter(outputFile);
        BufferedWriter buffer = new BufferedWriter(writer);
        PrintWriter print = new PrintWriter(buffer);
        writer = new FileWriter(outputFile, true);
    }

    @Test
    public void writeToAPrintWriterThenAppend() throws IOException {
        File outputFile = File.createTempFile("printWriterPrint", null);

        System.out.println("Check file " + outputFile.getAbsolutePath());

        FileWriter writer = new FileWriter(outputFile);
        BufferedWriter buffer = new BufferedWriter(writer);
        PrintWriter print = new PrintWriter(buffer);

        print.println("Append Print to Buffered Writer");

        print.close();

        // append to the file
        writer = new FileWriter(outputFile, true);
        buffer = new BufferedWriter(writer);
        print = new PrintWriter(buffer);
        print.println("==================================");
        print.close();

        String lineEnd = System.lineSeparator();
        long fileLen = 65L + lineEnd.length() + lineEnd.length();
        assertThat(outputFile.length(), is(fileLen));
    }

    @Test
    public void writingWithAFileWriter() throws IOException {
        File outputFile = File.createTempFile("fileWriter", null);

        FileWriter fileWriter = new FileWriter(outputFile);
        fileWriter.write("Simple Report With OutputWriter");
        fileWriter.write("===============================");
        fileWriter.close();
    }

    @Test
    public void readingTextFiles() throws IOException {
        File inputFile = File.createTempFile("fileReader", null);

        BufferedReader reader = new BufferedReader(new FileReader(inputFile));

        try {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } finally {
            reader.close();
        }
    }

    @Test
    public void spaceMethods() throws IOException {
        File temp = new File(System.getProperty("java.io.tmpdir"));

        long freeSpace = temp.getFreeSpace();
        long totalSpace = temp.getTotalSpace();
        long usableSpace = temp.getUsableSpace();

        File outputFile = writeTheTestDataFile(5);
        assertThat(outputFile.length(), is(expectedFileSize(5)));

        System.out.println("Length " + outputFile.length());
        System.out.println("Free " + freeSpace);
        System.out.println("Total " + totalSpace);
        System.out.println("Usable " + usableSpace);
    }

    private long expectedFileSize(int lines) {
        String lineEnd = System.lineSeparator();
        return (("line x".length() + lineEnd.length()) * lines);
    }

    private File writeTheTestDataFile(int lines) throws IOException {
        File outputFile = File.createTempFile("forReading" + lines + "_", null);
        PrintWriter print = new PrintWriter(new BufferedWriter(new FileWriter(outputFile)));
        for (int line = 0; line < lines; line++) {
            print.println("line " + lines);
        }
        print.close();
        return outputFile;
    }

    @Test
    public void listTempDirectory(){
        File tempDir = new File(System.getProperty("java.io.tmpdir"));

        String[] fileList = tempDir.list();

        for (String fileInList : fileList){
            System.out.println(fileInList);
        }
    }

    @Test
    public void listTempDirectoryContents(){
        File tempDir = new File(System.getProperty("java.io.tmpdir"));
        File[] fileList = tempDir.listFiles();

        for (File fileInList : fileList){
            String outputString = "";
            if (fileInList.isDirectory()){
                outputString += "DIR: ";
            }else {
                outputString +="FIL: ";
            }

            outputString += fileInList.getName();
            System.out.println(outputString);
        }
    }

    @Test
    public void listTempDirectoryAttribs(){
        File tempDir = new File(System.getProperty("java.io.tmpdir"));
        File[] fileList = tempDir.listFiles();

        for (File fileInList : fileList) {
            String outputString = "";
            if (fileInList.isDirectory()){
                outputString += "DIR: ";
            } else {
                outputString += "FIL: ";
            }

            if (fileInList.canRead()){
                outputString += "r";
            } else {
                outputString += "-";
            }

            if (fileInList.canWrite()){
                outputString += "w";
            } else {
                outputString += "-";
            }

            if (fileInList.canExecute()){
                outputString += "x";
            } else {
                outputString += "-";
            }

            outputString += " - " + fileInList.getName();

            SimpleDateFormat sdf = new SimpleDateFormat("y M d HH:mm:ss.SSS");
            String lastModified = sdf.format(new Date(fileInList.lastModified()));
            outputString += " => " + lastModified;
            System.out.println(outputString);
        }
    }

    @Test
    public void copyFile() throws IOException {
        File copyThis = writeTheTestDataFile();
        File toThis = new File(copyThis.getCanonicalPath() + ".copy");

        assertThat(toThis.exists(), is(false));

        Files.copy(copyThis.toPath(), toThis.toPath());

        assertThat(toThis.exists(), is(true));
        assertThat(copyThis.length(), is(toThis.length()));
    }

    @Test
    public void moveFile() throws IOException {
        File moveThis = writeTheTestDataFile();
        File toThis = new File(moveThis.getCanonicalPath() + ".moved");

        assertThat(moveThis.exists(), is(true));
        assertThat(toThis.exists(), is(false));

        Files.move(moveThis.toPath(), toThis.toPath(), REPLACE_EXISTING, ATOMIC_MOVE);

        assertThat(toThis.exists(), is(true));
        assertThat(moveThis.exists(), is(false));
    }
}
