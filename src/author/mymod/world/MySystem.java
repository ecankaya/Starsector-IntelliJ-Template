package author.mymod.world;

import com.fs.starfarer.api.Global;
import com.fs.starfarer.api.campaign.*;
import com.fs.starfarer.api.impl.campaign.ids.Conditions;
import com.fs.starfarer.api.impl.campaign.ids.Factions;

import java.awt.*;

public class MySystem {
    public void generate(SectorAPI sector) {

        StarSystemAPI system = sector.createStarSystem("Pasha");
        system.getLocation().set(-2000, -2000);

        // create the star and generate the hyperspace anchor for this system
        PlanetAPI PashaStar = system.initStar("Pasha", // unique id for this star
                "star_blue_giant", // id in planets.json
                800f, // radius (in pixels at default zoom)
                150); // corona radius, from star edge
        system.setLightColor(new Color(39, 155, 228)); // light color in entire system, affects all entities

        //add first stable loc
        SectorEntityToken stableLoc1 = system.addCustomEntity("pasha_stableloc_1", "Stable Location", "stable_location", Factions.NEUTRAL);
        stableLoc1.setCircularOrbit(PashaStar, 200, 5200, 520);

        //add gate
        SectorEntityToken gate = system.addCustomEntity("pasha_gate", "Inactive Gate","inactive_gate",Factions.NEUTRAL);
        gate.setFixedLocation(5000,5000);

        //add comm relay
        SectorEntityToken comm = system.addCustomEntity("pasha_comm_relay","Comm Relay", "comm_relay",Factions.NEUTRAL);
        comm.setCircularOrbit(PashaStar, 180,5000,240);

        PlanetAPI pBarren = system.addPlanet("pBarren",PashaStar,"Pasha I","barren",360 * (float) Math.random(),190f,5000f,900f);
        pBarren.getMarket().addCondition(Conditions.NO_ATMOSPHERE);
        pBarren.getMarket().addCondition(Conditions.RUINS_VAST);

        PlanetAPI pTerran = system.addPlanet("pTerran",PashaStar,"Pasha II","terran",360 * (float) Math.random(),250f,4000f,600f);
        pTerran.getMarket().addCondition(Conditions.FARMLAND_BOUNTIFUL);
        pTerran.getMarket().addCondition(Conditions.MILD_CLIMATE);
        pTerran.getMarket().addCondition(Conditions.HABITABLE);
        pTerran.getMarket().addCondition(Conditions.ORGANICS_PLENTIFUL);
        pTerran.getMarket().addCondition(Conditions.ORE_ULTRARICH);
        pTerran.getMarket().addCondition(Conditions.SOLAR_ARRAY);
        pTerran.getMarket().addCondition(Conditions.RUINS_VAST);

        PlanetAPI pVolcanic = system.addPlanet("pVolcanic",PashaStar,"Pasha III","lava",360 * (float) Math.random(),190f,4000f,300f);
        pVolcanic.getMarket().addCondition(Conditions.ORE_ULTRARICH);
        pVolcanic.getMarket().addCondition(Conditions.RARE_ORE_ULTRARICH);
        pVolcanic.getMarket().addCondition(Conditions.VERY_HOT);
        pVolcanic.getMarket().addCondition(Conditions.EXTREME_TECTONIC_ACTIVITY);
        pVolcanic.getMarket().addCondition(Conditions.RUINS_VAST);
        pVolcanic.getMarket().addCondition(Conditions.TOXIC_ATMOSPHERE);

        PlanetAPI pGas = system.addPlanet("pGas",PashaStar,"Pasha IV","gas_giant",360 * (float) Math.random(),320f,6000f,150f);
        pGas.getMarket().addCondition(Conditions.VOLATILES_PLENTIFUL);
        pGas.getMarket().addCondition(Conditions.HIGH_GRAVITY);
        //system.addEntity(jumpPoint3);

        system.autogenerateHyperspaceJumpPoints(true, true);

    }


    public void generateJumpPoint(StarSystemAPI system){
        JumpPointAPI jumpPoint3 = Global.getFactory().createJumpPoint(
                "fringe_jump",
                "Fringe System Jump");

        jumpPoint3.setCircularOrbit(system.getEntityById("Argon"), 2, 2000, 4000f);
        jumpPoint3.setStandardWormholeToHyperspaceVisual();
    }

}
