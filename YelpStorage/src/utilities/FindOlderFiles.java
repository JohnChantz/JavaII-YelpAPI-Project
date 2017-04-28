package utilities;

import java.io.File;

public class FindOlderFiles {

    private final String path = "records/";
    private File directory;
    File[] records;

    public FindOlderFiles() {
    }

    public void PrintExistingFile() {
        directory = new File(path);
        records = directory.listFiles();
        if (records.length == 0)
            System.out.println("No records from previous usage!");
        else
            for (File record : records) {
                System.out.println(record.getName());
            }
    }
}
