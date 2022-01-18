package samsungDXNo1;

import java.util.*;

class UserSolution
{
    static HashMap<Integer,int[]>[][] mapList = new HashMap[6][2];
    static ArrayList<Integer>[] chaeguel = new ArrayList[5];


    public void chaeguelPrint() {
        System.out.println("채결 가격 : ");
        for (int i = 0; i < chaeguel.length; i++) {
            ArrayList<Integer> a = chaeguel[i];
            for (Integer integer : a) {
                System.out.print(integer + " ");
            }
            System.out.println();
        }
    }

    public void mapListPrint() {
        //미해결 매수 매도 정
        System.out.println("미해결 매수 매도 정");
        for (int i = 0; i < 2; i++) {
            HashMap<Integer,int[]> a =  mapList[1][i];
            if(i == 0) System.out.println( "매수 ---- ");
            else System.out.println("매도 ----- ");
            for (Integer integer : a.keySet()) {
                System.out.println("주문 번호 : " + integer + " 수량 : " + a.get(integer)[0] + " 희망 가격 : " + a.get(integer)[1]);
            }
        }
    }
    
    public void init()
    {
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 2; j++) {
                mapList[i][j] = new HashMap<>();
            }
        }
        for (int i = 0; i < 5; i++) {
            chaeguel[i] = new ArrayList<>();
        }
    }

    public int buy(int mNumber, int mStock, int mQuantity, int mPrice)
    {
        //System.out.println("매수 --- 주문 번호 : " + mNumber + " 주식 종목 : " + mStock + " 수량 : " + mQuantity + " 희망 가격 : " + mPrice);
        HashMap<Integer,int[]> sellMap = mapList[mStock][1];
        if(sellMap.isEmpty()) {
            mapList[mStock][0].put(mNumber,new int[]{mQuantity,mPrice});
            return mQuantity;
        } else {
            //가능한 매도 주문 정보를 temp에 저장
            ArrayList<int[]> temp = new ArrayList<>();

            List<Map.Entry<Integer,int[]>> entryList = new ArrayList<>(sellMap.entrySet());

            //희망 가격 오름 차순 정렬 후 이분 탐색으로
            entryList.sort((a,b)->a.getValue()[1]-b.getValue()[1]);

            int start = 0; int end = entryList.size() - 1;
            while(start <= end) {
                int mid = (end + start) / 2;
                if(entryList.get(mid).getValue()[1] < mPrice) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }

            int check_quantity = mQuantity;

            for (int i = 0; i < entryList.size(); i++) {
                Map.Entry<Integer,int[]> a = entryList.get(i);
                if(a.getValue()[1] <= mPrice) {
                    temp.add(new int[]{a.getKey(),a.getValue()[0],a.getValue()[1]});
                    check_quantity -= a.getValue()[0];
                    if(check_quantity <= 0)
                        break;
                }
            }

//            for (Integer integer : sellMap.keySet()) {
//                if(sellMap.get(integer)[1] <= mPrice) {
//                    temp.add(new int[]{integer, sellMap.get(integer)[0], sellMap.get(integer)[1]});
//                    check_quantity -= sellMap.get(integer)[0];
//                    if(check_quantity <= 0)
//                        break;
//                }
//            }
            if(temp.size() == 0) {
                mapList[mStock][0].put(mNumber,new int[]{mQuantity,mPrice});
                return mQuantity;
            }
            else {
                Collections.sort(temp,(a,b)->a[2]-b[2]);
//                int price = temp.get(0)[2];
//                ArrayList<int[]> temp2 = new ArrayList<>();
//                for (int[] ints : temp2) {
//                    if(ints[2] == price)
//                        temp2.add(ints);
//                    else
//                        break;
//                }
//
//                Collections.sort(temp2,(a,b)->a[0]-b[0]); //주문 번호 낮은 순으로 정렬

                for (int[] ints : temp) {
                    chaeguel[mStock - 1].add(ints[2]); //채결 가격을 거래 순으로 채결 리스트에 저장

                    if(mQuantity <= ints[1]) { //매수 수량이 매도 주문의 수량보다 같거나 적을 경우
                        ints[1] -= mQuantity;
                        mQuantity = 0;
                        if(ints[1] == 0) {
                            mapList[mStock][1].remove(ints[0]);
                        } else {
                            mapList[mStock][1].put(ints[0],new int[]{ints[1],ints[2]});
                        }
                        break;
                    }
                    else {//매수 수량이 매도 주문의 수량보다 클 경우
                        mQuantity -= ints[1];
                        mapList[mStock][1].remove(ints[0]);
                    }
                }
            }
        }
        if(mQuantity != 0) mapList[mStock][0].put(mNumber,new int[]{mQuantity,mPrice});
        //mapListPrint();
        return mQuantity;
    }

    public int sell(int mNumber, int mStock, int mQuantity, int mPrice)
    {
        //System.out.println("매도 --- 주문 번호 : " + mNumber + " 주식 종목 : " + mStock + " 수량 : " + mQuantity + " 희망 가격 : " + mPrice);
        HashMap<Integer,int[]> buyMap = mapList[mStock][0];
        if(buyMap.isEmpty()) {
            mapList[mStock][1].put(mNumber,new int[]{mQuantity,mPrice});
            return mQuantity;
        } else {
            //가능한 매수 주문 정보를 temp에 저장
            ArrayList<int[]> temp = new ArrayList<>();

            List<Map.Entry<Integer,int[]>> entryList = new ArrayList<>(buyMap.entrySet());

            //희망 가격 내림 차순 정렬 후 이분 탐색으로
            entryList.sort((a,b)->b.getValue()[1]-a.getValue()[1]);

            int start = 0; int end = entryList.size() - 1;
            while(start <= end) {
                int mid = (end + start) / 2;
                if(entryList.get(mid).getValue()[1] > mPrice) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }

            int check_quantity = mQuantity;
            for (int i = 0; i < entryList.size(); i++) {
                Map.Entry<Integer,int[]> entry =  entryList.get(i);
                if(entry.getValue()[1] >= mPrice) {
                    temp.add(new int[]{entry.getKey(),entry.getValue()[0],entry.getValue()[1]});
                    check_quantity -= entry.getValue()[0];
                    if(check_quantity <= 0) {
                        break;
                    }
                }
            }

//            수량이 초과되면 그 다음은 담을 필요 없다.. 브레이크 필요
//            int check_quantity = mQuantity;
//            for (Integer integer : buyMap.keySet()) {
//                if(buyMap.get(integer)[1] >= mPrice) {
//                    temp.add(new int[]{integer,buyMap.get(integer)[0],buyMap.get(integer)[1]});
//                    check_quantity -= buyMap.get(integer)[0];
//                    if(check_quantity <= 0)
//                        break;
//                }
//            }
            if(temp.size() == 0) {
                mapList[mStock][1].put(mNumber,new int[]{mQuantity,mPrice});
                return mQuantity;
            }
            else {
                Collections.sort(temp,(a,b)->b[2]-a[2]); //매수 희망 가격 높은 순 정렬

//                int price = temp.get(0)[2];
//                ArrayList<int[]> temp2 = new ArrayList<>();
//                for (int[] ints : temp2) {
//                    if(ints[2] == price)
//                        temp2.add(ints);
//                    else
//                        break;
//                }
//
//                Collections.sort(temp2,(a,b)->a[0]-b[0]); //주문 번호 낮은 순으로 정렬

                for (int[] ints : temp) {
                    chaeguel[mStock - 1].add(ints[2]); //채결 가격을 거래 순으로 채결 리스트에 저장

                    if(mQuantity <= ints[1]) { //매수 수량이 매도 주문의 수량보다 같거나 적을 경우
                        ints[1] -= mQuantity;
                        mQuantity = 0;
                        if(ints[1] == 0) {
                            mapList[mStock][0].remove(ints[0]);
                        } else {
                            mapList[mStock][0].put(ints[0],new int[]{ints[1],ints[2]});
                        }
                        break;
                    }
                    else {//매수 수량이 매도 주문의 수량보다 클 경우
                        mQuantity -= ints[1];
                        mapList[mStock][0].remove(ints[0]);
                    }
               }
            }
        }
        if(mQuantity != 0) mapList[mStock][1].put(mNumber,new int[]{mQuantity,mPrice});
        //mapListPrint();
        return mQuantity;
    }

    public void cancel(int mNumber)
    {
        for (int i = 1; i < mapList.length; i++) {
            for (int j = 0; j < 2; j++) {
                if(mapList[i][j].containsKey(mNumber)) {
                    mapList[i][j].remove(mNumber);
                    return;
                }
            }
        }

    }

    public int bestProfit(int mStock)
    {
        ArrayList<Integer> c = chaeguel[mStock-1];
        //chaeguelPrint();
        if(c.size()==1)
            return 0;
        if(c.size() == 0)
            return 0;
        int max = 0;
        for (int i = chaeguel[mStock-1].size() - 1; i >= 1; i--) {
            for (int j = i-1; j >= 0; j--) {
                max = Math.max(max,c.get(i) - c.get(j));
            }
        }

        return max;
    }
}