package Pasha.RacingSector.world;

import com.fs.starfarer.api.Global;
import com.fs.starfarer.api.campaign.*;
import com.fs.starfarer.api.campaign.econ.MarketAPI;
import com.fs.starfarer.api.characters.FullName;
import com.fs.starfarer.api.characters.PersonAPI;
import com.fs.starfarer.api.impl.campaign.ids.Factions;
import com.fs.starfarer.api.impl.campaign.ids.People;
import com.fs.starfarer.api.impl.campaign.ids.Ranks;
import org.magiclib.util.MagicCampaign;


public class MySystem {
    public void generate(SectorAPI sector) {

        FullName name = new FullName("Emre", "Pasha", FullName.Gender.MALE);

        MarketAPI maxios = Global.getSector().getEntityById("new_maxios").getMarket();
//        PersonAPI rando = Global.getSector().getFaction(Factions.INDEPENDENT).createRandomPerson();

         MagicCampaign.addCustomPerson(
                 maxios,
                name.getFirst(),
                name.getLast(),
                People.DARDAN_KATO,
                FullName.Gender.MALE,
                Factions.INDEPENDENT,
                Ranks.PILOT,
                "criminal",
                false,
                 0,
                 5)
                 .setImportance(PersonImportance.VERY_HIGH
                 );

//        People.assignPost(maxios,"criminal",rando);
    }
}
