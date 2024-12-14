// This is a personal academic project. Dear PVS-Studio, please check it.
// PVS-Studio Static Code Analyzer for C, C++, C#, and Java: https://pvs-studio.com
package goldswan.calculator.vulnerabilities;

public class CommandInjection {

    public static String coordinateTransformLatLonToUTM(String coordinates) {
        String utmCoords = null;
        try {
            Runtime rt = Runtime.getRuntime();
            Process exec = rt.exec("echo " + coordinates);
            // process results of coordinate transform
        } catch (Exception e) {
            // handle exception
        }
        return utmCoords;
    }
}
