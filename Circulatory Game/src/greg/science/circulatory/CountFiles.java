package greg.science.circulatory;

import java.io.File;

public class CountFiles {
	
	
    public int[] count() {
        File f = new File("greg/science/circulatory/res");
        int count = 0;
        for (File file : f.listFiles()) {
                if (file.isFile()) {
                        count++;
                }
        }
        System.out.println("Number of files: " + count);
        int [] data = {count,2};
        return(data);
    }
}
