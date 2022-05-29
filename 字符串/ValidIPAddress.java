package 字符串;

/**
 * @className: ValidIPAddress
 * @description: 468. 验证IP地址
 * @author: Carl Tong
 * @date: 2022/5/29 11:00
 */
public class ValidIPAddress {
    public String validIPAddress(String queryIP) {
        if (queryIP == null || queryIP.length() <= 0) return "Neither";
        if (queryIP.charAt(0) != '.' && queryIP.charAt(queryIP.length() - 1) != '.' && isIPv4(queryIP)) return "IPv4";
        if (queryIP.charAt(0) != ':' && queryIP.charAt(queryIP.length() - 1) != ':' && isIPv6(queryIP)) return "IPv6";
        return "Neither";
    }

    private boolean isIPv4(String queryIP) {
        String[] ips = queryIP.split("\\.");
        if (ips.length != 4) return false;
        for (int i = 0; i < ips.length; i++) {
            String ip = ips[i];
            if (ip.length() <= 0 || ip.length() > 4) return false;
            if (ip.length() > 1 && ip.charAt(0) == '0') return false;
            for (int j = 0; j < ip.length(); j++) {
                if (ip.charAt(j) < '0' || ip.charAt(j) > '9') return false;
            }
            int value = Integer.parseInt(ip);
            if (value < 0 || value > 255) return false;
        }
        return true;
    }

    private boolean isIPv6(String queryIP) {
        String[] ips = queryIP.split(":");
        if (ips.length != 8) return false;
        for (int i = 0; i < ips.length; i++) {
            String ip = ips[i];
            if (ip.length() <= 0 || ip.length() > 4) return false;
            for (int j = 0; j < ip.length(); j++) {
                char c = ip.charAt(j);
                if (!((c >= '0' && c <= '9') || (c >= 'a' && c <= 'f') || (c >= 'A' && c <= 'F'))) return false;
            }
        }
        return true;
    }
}

class TestValid  {
    public static void main(String[] args) {
        String s = new ValidIPAddress().validIPAddress("20EE:FGb8:85a3:0:0:8A2E:0370:7334");
        System.out.println(s);
    }
}
