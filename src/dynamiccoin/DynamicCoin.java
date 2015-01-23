/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author biswajitb
 */
package dynamiccoin;
import java.util.Arrays;
public class DynamicCoin {

    /**
     * @param args the command line arguments
     */
    private int sum, coins[];
    public DynamicCoin(int sum, int[] coins)
    {
        this.sum = sum;
        this.coins = coins;
    }
    
    public String toString()
    {
        return new String("Sum = " + sum + ", coins = " + Arrays.toString(coins));
    }
    
    public void calculate() throws Exception
    {
        int[] Min = new int[sum+1];
        for(int i=0; i<Min.length; i++)
        {
            Min[i] = 999;   //any arbitrary value as infinity
        }
        Min[0] = 0;
        
        for(int i=1; i<=sum; i++)
        {
            for(int j=0; j<coins.length; j++)
            {
                if(coins[j] <= i && (Min[i - coins[j]]+1) < Min[i])
                    Min[i] = Min[i - coins[j]]+1;
            }
        }
        System.out.println("The Solution is as follows");
        for(int i=0;i<=sum;i++)
            System.out.println("Min[" + i + "] = " + Min[i]);
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        int sum = 11;
        int[] coins = {1, 3, 5};
        DynamicCoin obj = new DynamicCoin(sum,coins);
        System.out.println(obj);
        try
        {
            obj.calculate();
        }catch(Exception e)
        {
            System.out.println("Exception Occured !");
            e.printStackTrace();
        }
    }
    
}
