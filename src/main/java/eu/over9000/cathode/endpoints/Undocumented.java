package eu.over9000.cathode.endpoints;

import eu.over9000.cathode.Result;
import eu.over9000.cathode.data.PanelList;

public interface Undocumented {

	Result<PanelList> getPanels(String channelName);
}
