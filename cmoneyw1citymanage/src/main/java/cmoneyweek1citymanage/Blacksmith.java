package cmoneyweek1citymanage;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author kisso
 */
public class Blacksmith extends Building{
    private int armyLife; //士兵生命值
    private int armyLevel;//士兵等級
    
    private int aircraftLife;//飛機生命值
    private int aircraftLevel;//飛機等級
    
    public Blacksmith(){

        //建築編號
        this.setNumber(6);
        //建築名稱
        this.setName("兵工廠");
        //建築等級
        this.setBuildingLevel(1);
        //建築生命值
        this.setLife(30);
        //建造所需資源
        this.setBuildResource(new Resource(30,10,0));
        //建築狀態
        this.setBuildCheck(Building.BuildCheck.BUILDABLE);
        //建造所需時間
        this.setBuildNeedTime(3);
        //建築建好時間
        this.setBuildTime(-1);
        //建造需要文明等級
        this.setNeedCivilLevel(2);
        //升級所需資源
        this.setUpgradeResource(new Resource(70,40,0));
        //升級狀態
        this.setUpgradeCheck(Building.UpgradeCheck.NOTUPGRADEABLE);
        //建築物功能開關
        this.setOnOff(false);
        //升級需要文明等級
        this.setUpNeedCivilLevel(2);
        
        
        //起始士兵等級是1
        armyLevel = 1;
        //起始飛機等級是1
        this.aircraftLevel = 1;


    }
    
    //升級士兵>>士兵等級+1
    //士兵生命值改動    
    public void upgradeArmy() {
        this.armyLevel ++;
    }
    
    public int getArmyLevel() {
        return armyLevel;
    }

    public int getArmyLife() {
        armyLife = armyLevel*3-1;
        return armyLife;
    }
    //升級飛機>>飛機等級+1
    //飛機生命值改動
    public void upgradeAircraft() {
        this.aircraftLevel ++;
    }

    public int getAircraftLevel() {
        return aircraftLevel;
    }
    
    public int getAircraftLife() {
        //飛機生命值=飛機等級*2
        aircraftLife = this.getAircraftLevel()*2;
        return aircraftLife;
    }

    /**
     * 印出建造資訊
     * @return 印出建造資訊
     */
    @Override
    public void printBuild() {
        System.out.println(getNumber() + "." + getName() +
                            "　:(建造成本:木材" + getBuildResource().getWood() +
                            " 鋼鐵" + getBuildResource().getSteel() +
                            " 所需文明等級: " + getNeedCivilLevel() +
                            " )\t功能：可以升級士兵及飛機");
    }

    //印出升級資訊
    @Override
    public void printUpgrade() {
        System.out.println(getNumber() + "." + getName() +
                            "　:(升級成本:木材" + getUpgradeResource().getWood() +
                            " 鋼鐵" + getUpgradeResource().getSteel() +
                            " 所需文明等級: " + getUpNeedCivilLevel() +
                            " )\t升級功能:可以選擇升級士兵科技或飛機科技");
    }
}
