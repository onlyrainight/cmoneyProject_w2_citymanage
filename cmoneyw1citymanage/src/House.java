public class House extends Building{
    /**
     * 升級所需時間
     * 村民生命值
     * 村民生產速度
     */
    private int villagerGenRate;
    private int villagerLife;


    public House(){
        //建築編號
        setNumber(1);
        //建築名稱
        setName("房  屋");
        //建築生命值
        setLife(10);
        //建造所需資源
        setBuildResource(new Resource(10,0,0));
        //建造所需時間
        setInitialBuildTime(1);
        //建築剩餘時間
        setBuildNeedTime(getInitialBuildTime());
        //建造需要文明等級
        setNeedCivilLevel(1);
        //升級所需資源
        setUpgradeResource(new Resource(30,15,0));
        //升級所需時間
        setUpgradeResetTime(30);
        //升級剩餘時間
        setUpgradeNeedTime(getUpgradeResetTime());
        //自動生產消耗資源
        setEffectResource(new Resource(1,0,0));
        //升級需要文明等級
        setUpNeedCivilLevel(2);

        this.villagerLife = 1;
    }

    //生產市民效率，每次取用就重新計算
    @Override
    public int getRate() {
        villagerGenRate = this.getBuildingLevel()*2-1;
        return villagerGenRate;
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
                " )\t功能：每24小時消耗" + getEffectResource().getWood() + "木材" +
                "，產生" + this.getBuildingLevel() + "個市民");
    }

    //印出升級資訊
    @Override
    public void printUpgrade() {
        System.out.println(getNumber() + "." + getName() +
                "　:(升級成本:木材" + getUpgradeResource().getWood() +
                " 鋼鐵" + getUpgradeResource().getSteel() +
                " 所需文明等級: " + getUpNeedCivilLevel() +
                " )\t升級功能:每24小時消耗" + getEffectResource().getWood() + "木材" +
                "，產生" + (this.getBuildingLevel() + 1) + "個市民");
    }
}