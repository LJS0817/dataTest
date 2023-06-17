package com.example.beauty;

import android.util.Log;

public class data {
    /* 화장품 구분 [ 0 ~ 3 ]
    * 0 = 스킨
    * 1 = 로션
    * 2 = 에센스
    * 3 = 크림  */
    private int type;
    
    //화장품 이름
    //id = recipe_name
    private String name;

    /* 피부 타입 [ 0 ~ 5 ]
    * 0 = 민감성 피부
    * 1 = 건성
    * 2 = 아토피 피부
    * 3 = 중복합성 피부
    * 4 = 지성
    * 5 = 여드름 피부 */
    private int skin;
    
    //총 용량
    //id = total_weight
    private int weight;

    //0.0 ~ 1.0 = 0% ~ 100%
    //id = total_su
    private double su_per;
    //id = total_u
    private double u_per;
    //id = total_hwa
    private double hwa_per;

    //Edit_Text 내부 Text 만 저장
    //불러온 후 계산
    //id = su_water
    private String water;
    //id = su_add
    private String add;
    //id = u_oil
    private String oil;
    //id = hwa_mix
    private String mix;
    //id = eo_use
    private String eo;
    //id = memo
    private String memo;

    private String date;

    private String path;

    public data()
    {
        setSkin(-1);
    }

    public Object getData(int id)
    {
        if(id == R.id.recipe_name) return name == null ? "" : name;
        else if(id == R.id.total_weight) return weight;
        else if(id == R.id.total_su) return (int)(su_per * 100);
        else if(id == R.id.total_u) return (int)(u_per * 100);
        else if(id == R.id.total_hwa) return (int)(hwa_per * 100);
        else if(id == R.id.su_water) return water == null ? "" : water;
        else if(id == R.id.su_add) return add == null ? "" : add;
        else if(id == R.id.u_oil) return oil == null ? "" : oil;
        else if(id == R.id.hwa_mix) return mix == null ? "" : mix;
        else if(id == R.id.eo_use) return eo == null ? "" : eo;
        else return memo == null ? "" : memo;
    }

    public void setData(int id, String val)
    {
        if(id == R.id.recipe_name) name = val;
        else if(id == R.id.total_weight) weight = (!val.isEmpty() && val != null ? Integer.parseInt(val) : weight);
        else if(id == R.id.total_su) su_per = (!val.isEmpty() && val != null ? Double.parseDouble(val) * 0.01 : su_per);
        else if(id == R.id.total_u) u_per = (!val.isEmpty() && val != null ? Double.parseDouble(val) * 0.01 : u_per);
        else if(id == R.id.total_hwa) hwa_per = (!val.isEmpty() && val != null ? Double.parseDouble(val) * 0.01 : hwa_per);
        else if(id == R.id.su_water) water = val;
        else if(id == R.id.su_add) add = val;
        else if(id == R.id.u_oil) oil = val;
        else if(id == R.id.hwa_mix) mix = val;
        else if(id == R.id.eo_use) eo = val;
        else memo = val;
    }

    public void setType(int n)
    {
        type = n - 1;
        setDefault();
    }
    public int getType()
    {
        return type;
    }
    public String getType_toString() { return Integer.toString(type); }
    public String getType_toText()
    {
        if(type == 0) return "스킨";
        else if(type == 1) return "로션";
        else if(type == 2) return "에센스";
        else return "크림";
    }

    public void setName(String s) { name = s; }
    public String getName() { return name == null ? "" : name; }

    public void setSkin(int n) { skin = n; }
    public int getSkin() { return skin; }
    public String getSkin_toString() { return Integer.toString(skin); }

    public String getSkin_Type_toText() {
        if(skin == 0) return "민감성 피부";
        else if(skin == 1) return "건성";
        else if(skin == 2) return "아토피 피부";
        else if(skin == 3) return "중복합성 피부";
        else if(skin == 4) return "지성";
        else return "여드름 피부";
    }

    public void setWeight(int n) { weight = n; }
    public int getWeight() { return weight; }
    public String getWeight_toString() { return Integer.toString(weight); }

    public void setDefault()
    {
        if (type == 0)
        {
            su_per = 1;
            u_per = 0;
            hwa_per = 0;
        }
        else if(type == 1)
        {
            su_per = 0.7;
            u_per = 0.3;
            hwa_per = 0.03;
        }
        else if(type == 2)
        {
            su_per = 0.85;
            u_per = 0.15;
            hwa_per = 0.02;
        }
        else
        {
            su_per = 0.6;
            u_per = 0.4;
            hwa_per = 0.05;
        }
    }

    public void setSu(double n) { su_per = n; }
    public double getSu() { return su_per; }
    public String getSu_toString() { return Double.toString(su_per); }

    public void setU(double n) { u_per = n; }
    public double getU() { return u_per; }
    public String getU_toString() { return Double.toString(u_per); }

    public void setHwa(double n) { hwa_per = n; }
    public double getHwa() { return hwa_per; }
    public String getHwa_toString() { return Double.toString(hwa_per); }

    public void setWater(String s) { water = s; }
    public String getWater() { return water == null ? "" : water; }

    public void setAdd(String s) { add = s; }
    public String getAdd() { return add == null ? "" : add; }

    public void setOil(String s) { oil = s; }
    public String getOil() { return oil == null ? "" : oil; }

    public void setMix(String s) { mix = s; }
    public String getMix() { return mix == null ? "" : mix; }

    public void setEo(String s) { eo = s; }
    public String getEo() { return eo == null ? "" : eo; }

    public void setMemo(String s) { memo = s; }
    public String getMemo() { return memo == null ? "" : memo; }

    public void setDate(String s) { date = s; }
    public String getDate() { return date == null ? "" : date; }

    public void setPath(String s) { path = s; }
    public String getPath() { return path == null ? "" : path; }

    public String getData_WithG(int t)
    {
        String[] str = (t == 0 ? water : (t == 1 ? add : (t == 2 ? oil : (t == 3 ? mix : eo)))).split("`");
        String cur = "";
        try {
            for(int i = 0; i < str.length; i++)
            {
                String g = str[i].substring(str[i].lastIndexOf(' ') + 1);
                String s = str[i].substring(0, str[i].lastIndexOf(' ')) + " : ";
                g += t == 4 ? "dr" : "g";
                cur += (s + g);
                if(i < str.length - 1)
                {
                    cur += "\n  ";
                }
            }
        } catch(IndexOutOfBoundsException e) {

        }

        return cur;
    }

    @Override
    public String toString(){
        return getType() + ";" + getSkin() + ";" + getName() + ";" + getWeight() + ";" + getSu() + ";" +
                getU() + ";" + getHwa() + ";" + getWater() + ";" + getAdd() + ";" + getOil() + ";" +
                getMix() + ";" + getEo() + ";" + getMemo() + ";" + getDate();
    }
}


package com.example.beauty;

import android.util.Log;

public class recipe_set {

    private String type;
    private String skin_type;

    private String name;
    private String date;
    private String weight;

    private String path;

    public recipe_set(int weight, String skin, String name, String date, String type, String path) {
        if(weight == -1) this.weight = "0G";
        else this.weight = weight + "G";

        this.skin_type = skin;
        this.name = name;
        this.date = date;
        this.type = type;
        this.path = path;
    }

    public String getWeight() {
        return weight;
    }

    public String getSkin_Type() {
        return skin_type;
    }
    public String getSkin_Type_toText() {
        if(skin_type.equals("0")) return "민감성 피부";
        else if(skin_type.equals("1")) return "건성";
        else if(skin_type.equals("2")) return "아토피 피부";
        else if(skin_type.equals("3")) return "중복합성 피부";
        else if(skin_type.equals("4")) return "지성";
        else return "여드름 피부";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public String getType() {
        return type;
    }

    public int getType_toInt()
    {
        return Integer.parseInt(type);
    }

    public String getType_toText()
    {
        if(type.equals("0")) return "스킨";
        else if(type.equals("1")) return "로션";
        else if(type.equals("2")) return "에센스";
        else return "크림";
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }
}
private data createData(String str)
    {
        data sample = new data();

        String[] s = str.split(";");

        sample.setType(Integer.parseInt(s[0]) + 1);
        sample.setSkin(Integer.parseInt(s[1]));

        sample.setName(s[2]);

        sample.setWeight(Integer.parseInt(s[3]));

        sample.setSu(Double.parseDouble(s[4]));
        sample.setU(Double.parseDouble(s[5]));
        sample.setHwa(Double.parseDouble(s[6]));

        sample.setWater(s[7]);
        sample.setAdd(s[8]);
        sample.setOil(s[9]);
        sample.setMix(s[10]);
        sample.setEo(s[11]);
        sample.setMemo(s[12]);
        sample.setDate(s[13]);

        return sample;
    }
