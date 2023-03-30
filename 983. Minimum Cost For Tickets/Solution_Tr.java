public class Solution_Tr {

    //link = https://leetcode.com/problems/minimum-cost-for-tickets/description/

    public int mincostTickets(int[] days, int[] costs){

        /*
            Dinamik Programlama kullanacağımız bir soru. 

            Son x günü geçirebileceğimiz minimum cost'u hesapladıktan sonra saklayarak
            bir sonraki hesapta kullanacağınız. (memoization)

            Yani sırası ile çözeceğimiz subproblemler aşağıdaki örnekteki gibi olacak:

            days : [1, 4, 6, 7, 8, 20] costs : [2, 7, 15]

            dp[7]: son sıfır gündeki seyahatleri [] minimum kaç lira ile geçirebiliriz?
            (Cevap 0)

            dp[7-1] = dp[6]: son 1 gündeki seyehatleri (Yani 6. gün ve sonrakinleri)
            [20] minimum kaç lira ile geçirebiliriz?
            Cevap: Cevabımız şu üç değerin minimumu olacak:

             günlük bilet maliyeti  + günlük biletin artık işe yaramayacağı ilk günkü minimum cost (daha önce hesaplanmıştı)
             haftalık bilet maliyeti + haftalık biletin o günden itibaren artık işe yaramayacağı ilk günün minimum cost'u 
             aylık bilet maliyeti + aylık biletin o günden itibaren artık işe yaramayacağı ilk günün maliyeti
             
        */


        //Son 0 gündeki ücreti de işin içine katacağımız için gün sayısından bir büyük boyutta
        //bir array'a ihtiyacımız var.
        int N = days.length;
        //Örnek: alttaki array'in 2. indexi 3. günden son güne kadar minimum ne kadar ücretle geçinebileceğimizi tutacak.
        //Array'ın ilk elemanı da tüm günlerin cevabı olacak. 
        int sonGunlerdekiMinimumUcret[] = new int[N+1];

        //Bu değişkenler her döngüde haftalık ve aylık biletlerin geçerli olduğu aralığı bulmamızda
        //Kullanılacak.
        /* Her döngüde i'den haftalikBiletSon index'ine kadar haftalık bilet geçerli, sonrasında biletin süresi bitmiş demektir*/
        int haftalikBiletSon, aylikBiletSon = 0;

        //Örneğin 6 günün olduğu bir soruda 5. index'ten 0'a, yani 6. günden ilk güne doğru hesaplarımızı 
        //yaparak gidiyoruz. Gün 0 günden son 6 güne, yani sondan başa gidiyoruz:
        for (int i = N - 1; i >= 0; i--)
        {
            haftalikBiletSon = aylikBiletSon = i;

            //Haftalık ve aylık bilet'in son indexlerini geçerli olmadıkları
            //ilk güne götürüyoruz. 
            //Örneğin i. index'te yani days[i]'de alınan haftalık bilet 
            //days[haftalikBiletSon] gününde artık işe yaramıyor olacak.

            while (haftalikBiletSon < N && days[haftalikBiletSon] < days[i] + 7)
                haftalikBiletSon++;

            while (aylikBiletSon < N && days[aylikBiletSon] < days[i] + 30)
                aylikBiletSon++;

            //i indexli günle sırası ile günlük, haftalık ve aylık bileti tercih ettiğimizde elde edebileceğimiz minimum ücreti hesaplıyoruz:
            sonGunlerdekiMinimumUcret[i] = Math.min(costs[0] + sonGunlerdekiMinimumUcret[i+1], 
                                           Math.min(costs[1] + sonGunlerdekiMinimumUcret[haftalikBiletSon], 
                                                    costs[2] + sonGunlerdekiMinimumUcret[aylikBiletSon]));
        }
        //ilk index ilk günden son güne, yani tüm günlerdeki minimum ücreti tutar.
        return sonGunlerdekiMinimumUcret[0];
    }

    public static void main(String[] args) {
        
    }

}

