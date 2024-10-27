package com.thealgorithms.maths;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;

import org.junit.jupiter.api.Test;

class SquareFreeIntegerTest {

    @Test
    void testIsSquareFreeInteger() {

        // given
        List<Integer> listOfSquareFreeIntegers = List.of(1, 2, 3, 5, 6, 7, 10, 11, 13, 14, 15, 17, 19, 21, 22, 23, 26, 29, 30, 31, 33, 34, 35, 37, 38, 39, 41, 42, 43, 46, 47, 51, 53, 55, 57, 58, 59, 61, 62, 65, 66, 67, 69, 70, 71, 73, 74, 77, 78, 79, 82, 83, 85, 86, 87, 89, 91, 93, 94, 95, 97, 101,
                102, 103, 105, 106, 107, 109, 110, 111, 113, 114, 115, 118, 119, 122, 123, 127, 129, 130, 131, 133, 134, 137, 138, 139, 141, 142, 143, 145, 146, 149, 151, 154, 155, 157, 158, 159, 161, 163, 165, 166, 167, 170, 173, 174, 177, 178, 179, 181, 182, 183, 185, 186, 187, 190, 191, 193, 194,
                195, 197, 199, 201, 202, 203, 205, 206, 209, 210, 211, 213, 214, 215, 217, 218, 219, 221, 222, 223, 226, 227, 229, 230, 231, 233, 235, 237, 238, 239, 241, 246, 247, 249, 251, 253, 254, 255, 257, 258, 259, 262, 263, 265, 266, 267, 269, 271, 273, 274, 277, 278, 281, 282, 283, 285, 286,
                287, 290, 291, 293, 295, 298, 299, 301, 302, 303, 305, 307, 309, 310, 311, 313, 314, 317, 318, 319, 321, 322, 323, 326, 327, 329, 330, 331, 334, 335, 337, 339, 341, 345, 346, 347, 349, 353, 354, 355, 357, 358, 359, 362, 365, 366, 367, 370, 371, 373, 374, 377, 379, 381, 382, 383, 385,
                386, 389, 390, 391, 393, 394, 395, 397, 398, 399, 401, 402, 403, 406, 407, 409, 410, 411, 413, 415, 417, 418, 419, 421, 422, 426, 427, 429, 430, 431, 433, 434, 435, 437, 438, 439, 442, 443, 445, 446, 447, 449, 451, 453, 454, 455, 457, 458, 461, 462, 463, 465, 466, 467, 469, 470, 471,
                473, 474, 478, 479, 481, 482, 483, 485, 487, 489, 491, 493, 494, 497, 498, 499, 501, 502, 503, 505, 506, 509, 510, 511, 514, 515, 517, 518, 519, 521, 523, 526, 527, 530, 533, 534, 535, 537, 538, 541, 542, 543, 545, 546, 547, 551, 553, 554, 555, 557, 559, 561, 562, 563, 565, 566, 569,
                570, 571, 573, 574, 577, 579, 581, 582, 583, 586, 587, 589, 590, 591, 593, 595, 597, 598, 599, 601, 602, 606, 607, 609, 610, 611, 613, 614, 615, 617, 618, 619, 622, 623, 626, 627, 629, 631, 633, 634, 635, 638, 641, 642, 643, 645, 646, 647, 649, 651, 653, 654, 655, 658, 659, 661, 662,
                663, 665, 667, 669, 670, 671, 673, 674, 677, 678, 679, 681, 682, 683, 685, 687, 689, 690, 691, 694, 695, 697, 698, 699, 701, 703, 705, 706, 707, 709, 710, 713, 714, 715, 717, 718, 719, 721, 723, 727, 730, 731, 733, 734, 737, 739, 741, 742, 743, 745, 746, 749, 751, 753, 754, 755, 757,
                758, 759, 761, 762, 763, 766, 767, 769, 770, 771, 773, 777, 778, 779, 781, 782, 785, 786, 787, 789, 790, 791, 793, 794, 795, 797, 798, 799, 802, 803, 805, 806, 807, 809, 811, 813, 814, 815, 817, 818, 821, 822, 823, 826, 827, 829, 830, 831, 834, 835, 838, 839, 842, 843, 849, 851, 853,
                854, 857, 858, 859, 861, 862, 863, 865, 866, 869, 870, 871, 874, 877, 878, 879, 881, 883, 885, 886, 887, 889, 890, 893, 894, 895, 897, 898, 899, 901, 902, 903, 905, 906, 907, 910, 911, 913, 914, 915, 917, 919, 921, 922, 923, 926, 929, 930, 933, 934, 935, 937, 938, 939, 941, 942, 943,
                946, 947, 949, 951, 953, 955, 957, 958, 959, 962, 965, 966, 967, 969, 970, 971, 973, 974, 977, 978, 979, 982, 983, 985, 986, 987, 989, 991, 993, 994, 995, 997, 998, 1001, 1002, 1003, 1005, 1006, 1007, 1009, 1010, 1011, 1013, 1015, 1018, 1019, 1021, 1022, 1023, 1027, 1030, 1031, 1033,
                1034, 1037, 1038, 1039, 1041, 1042, 1043, 1045, 1046, 1047, 1049, 1051, 1054, 1055, 1057, 1059, 1061, 1063, 1065, 1066, 1067, 1069, 1070, 1073, 1074, 1077, 1079, 1081, 1082, 1085, 1086, 1087, 1090, 1091, 1093, 1094, 1095, 1097, 1099, 1101, 1102, 1103, 1105, 1106, 1109, 1110, 1111, 1113,
                1114, 1115, 1117, 1118, 1119, 1121, 1122, 1123, 1126, 1129, 1130, 1131, 1133, 1135, 1137, 1138, 1139, 1141, 1142, 1145, 1146, 1147, 1149, 1151, 1153, 1154, 1155, 1157, 1158, 1159, 1162, 1163, 1165, 1166, 1167, 1169, 1171, 1173, 1174, 1177, 1178, 1181, 1182, 1185, 1186, 1187, 1189, 1190,
                1191, 1193, 1194, 1195, 1198, 1199, 1201, 1202, 1203, 1205, 1207, 1209, 1211, 1213, 1214, 1217, 1218, 1219, 1221, 1222, 1223, 1226, 1227, 1229, 1230, 1231, 1234, 1235, 1237, 1238, 1239, 1241, 1243, 1245, 1246, 1247, 1249, 1253, 1254, 1255, 1257, 1258, 1259, 1261, 1262, 1263, 1265, 1266,
                1267, 1270, 1271, 1273, 1277, 1279, 1281, 1282, 1283, 1285, 1286, 1289, 1290, 1291, 1293, 1294, 1295, 1297, 1298, 1299, 1301, 1302, 1303, 1306, 1307, 1309, 1310, 1311, 1313, 1315, 1317, 1318, 1319, 1321, 1322, 1326, 1327, 1329, 1330, 1333, 1334, 1335, 1337, 1338, 1339, 1342, 1343, 1345,
                1346, 1347, 1349, 1351, 1353, 1354, 1355, 1357, 1358, 1361, 1362, 1363, 1365, 1366, 1367, 1370, 1371, 1373, 1374, 1378, 1379, 1381, 1382, 1383, 1385, 1387, 1389, 1390, 1391, 1393, 1394, 1397, 1398, 1399, 1401, 1402, 1403, 1405, 1406, 1407, 1409, 1410, 1411, 1414, 1415, 1417, 1418, 1419,
                1423, 1426, 1427, 1429, 1430, 1433, 1434, 1435, 1437, 1438, 1439, 1441, 1442, 1443, 1446, 1447, 1451, 1453, 1454, 1455, 1457, 1459, 1461, 1462, 1463, 1465, 1466, 1469, 1471, 1473, 1474, 1477, 1478, 1479, 1481, 1482, 1483, 1486, 1487, 1489, 1490, 1491, 1493, 1495, 1497, 1498, 1499, 1501,
                1502, 1505, 1506, 1507, 1509, 1510, 1511, 1513, 1514, 1515, 1517, 1518, 1522, 1523, 1526, 1527, 1529, 1531, 1533, 1534, 1535, 1537, 1538, 1541, 1542, 1543, 1545, 1546, 1547, 1549, 1551, 1553, 1554, 1555, 1558, 1559, 1561, 1562, 1563, 1565, 1567, 1569, 1570, 1571, 1574, 1577, 1578, 1579,
                1581, 1582, 1583, 1585, 1586, 1589, 1590, 1591, 1594, 1595, 1597, 1598, 1599, 1601, 1603, 1605, 1606, 1607, 1609, 1610, 1613, 1614, 1615, 1618, 1619, 1621, 1622, 1623, 1626, 1627, 1630, 1631, 1633, 1634, 1635, 1637, 1639, 1641, 1642, 1643, 1645, 1646, 1649, 1651, 1653, 1654, 1655, 1657,
                1658, 1659, 1661, 1662, 1663, 1667, 1669, 1670, 1671, 1673, 1677, 1678, 1679, 1685, 1686, 1687, 1689, 1691, 1693, 1695, 1697, 1698, 1699, 1702, 1703, 1705, 1706, 1707, 1709, 1711, 1713, 1714, 1717, 1718, 1721, 1722, 1723, 1726, 1727, 1729, 1730, 1731, 1733, 1735, 1738, 1739, 1741, 1742,
                1743, 1745, 1747, 1749, 1751, 1753, 1754, 1757, 1758, 1759, 1761, 1762, 1763, 1765, 1766, 1767, 1769, 1770, 1771, 1774, 1777, 1778, 1779, 1781, 1783, 1785, 1786, 1787, 1789, 1790, 1793, 1794, 1795, 1797, 1798, 1799, 1801, 1802, 1803, 1806, 1807, 1810, 1811, 1814, 1817, 1819, 1821, 1822,
                1823, 1826, 1829, 1830, 1831, 1833, 1834, 1835, 1837, 1838, 1839, 1841, 1842, 1843, 1846, 1847, 1851, 1853, 1855, 1857, 1858, 1861, 1865, 1866, 1867, 1869, 1870, 1871, 1873, 1874, 1877, 1878, 1879, 1882, 1883, 1885, 1886, 1887, 1889, 1891, 1893, 1894, 1895, 1897, 1898, 1901, 1902, 1903,
                1905, 1906, 1907, 1909, 1910, 1913, 1914, 1915, 1918, 1919, 1921, 1923, 1927, 1929, 1930, 1931, 1933, 1934, 1937, 1938, 1939, 1941, 1942, 1943, 1945, 1946, 1947, 1949, 1951, 1954, 1955, 1957, 1958, 1959, 1961, 1963, 1965, 1966, 1967, 1969, 1970, 1973, 1974, 1977, 1978, 1979, 1981, 1982,
                1983, 1985, 1986, 1987, 1990, 1991, 1993, 1994, 1995, 1997, 1999, 2001, 2002, 2003, 2005, 2006, 2010, 2011, 2013, 2014, 2015, 2017, 2018, 2019, 2021, 2022, 2026, 2027, 2029, 2030, 2031, 2033, 2035, 2037, 2038, 2039, 2041, 2042, 2045, 2046, 2047, 2049, 2051, 2053, 2054, 2055, 2059, 2062,
                2063, 2065, 2066, 2067, 2069, 2071, 2073, 2074, 2077, 2078, 2081, 2082, 2083, 2085, 2086, 2087, 2089, 2090, 2091, 2093, 2094, 2095, 2098, 2099, 2101, 2102, 2103, 2105, 2109, 2110, 2111, 2113, 2114, 2117, 2118, 2119, 2121, 2122, 2123, 2126, 2127, 2129, 2130, 2131, 2134, 2135, 2137, 2138,
                2139, 2141, 2143, 2145, 2146, 2147, 2149, 2153, 2154, 2155, 2157, 2158, 2159, 2161, 2162, 2163, 2165, 2167, 2170, 2171, 2173, 2174, 2177, 2179, 2181, 2182, 2183, 2185, 2186, 2189, 2190, 2191, 2193, 2194, 2195, 2198, 2199, 2201, 2202, 2203, 2206, 2207, 2210, 2211, 2213, 2215, 2217, 2218,
                2219, 2221, 2222, 2226, 2227, 2229, 2230, 2231, 2233, 2234, 2235, 2237, 2238, 2239, 2242, 2243, 2245, 2246, 2247, 2249, 2251, 2253, 2255, 2257, 2258, 2261, 2262, 2263, 2265, 2266, 2267, 2269, 2270, 2271, 2273, 2274, 2278, 2279, 2281, 2282, 2283, 2285, 2287, 2289, 2290, 2291, 2293, 2294,
                2297, 2298, 2301, 2302, 2305, 2306, 2307, 2309, 2310, 2311, 2314, 2315, 2317, 2318, 2319, 2321, 2323, 2326, 2327, 2329, 2330, 2333, 2334, 2335, 2337, 2338, 2339, 2341, 2342, 2343, 2345, 2346, 2347, 2351, 2353, 2354, 2355, 2357, 2359, 2361, 2362, 2363, 2365, 2369, 2370, 2371, 2373, 2374,
                2377, 2378, 2379, 2381, 2382, 2383, 2386, 2387, 2389, 2390, 2391, 2393, 2395, 2397, 2398, 2399, 2402, 2405, 2406, 2407, 2409, 2410, 2411, 2413, 2414, 2415, 2417, 2418, 2419, 2422, 2423, 2426, 2427, 2429, 2431, 2433, 2434, 2435, 2437, 2438, 2441, 2442, 2443, 2445, 2446, 2447, 2449, 2451,
                2453, 2454, 2455, 2458, 2459, 2461, 2462, 2463, 2465, 2467, 2469, 2470, 2471, 2473, 2474, 2477, 2478, 2479, 2481, 2482, 2483, 2485, 2486, 2487, 2489, 2490, 2491, 2494, 2495, 2497, 2498);

        for (int i = 1; i <= 2500; i++) {
            // when
            boolean isNumberSquareFree = SquareFreeInteger.isSquareFreeInteger(i);
            boolean isNumberPresentInList = listOfSquareFreeIntegers.contains(i);

            // then
            assertEquals(isNumberSquareFree, isNumberPresentInList);
        }
    }

    @Test
    void testIsSquareFreeIntegerThrowExceptionIfNumberIsZero() {
        // given
        int number = 0;
        String expectedMessage = "Number must be greater than zero.";

        // when
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            SquareFreeInteger.isSquareFreeInteger(number);
        });
        String actualMessage = exception.getMessage();

        // then
        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    void testIsSquareFreeIntegerMustThrowExceptionIfNumberIsNegative() {
        // given
        int number = -1;
        String expectedMessage = "Number must be greater than zero.";

        // when
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            SquareFreeInteger.isSquareFreeInteger(number);
        });
        String actualMessage = exception.getMessage();

        // then
        assertEquals(expectedMessage, actualMessage);
    }
}
