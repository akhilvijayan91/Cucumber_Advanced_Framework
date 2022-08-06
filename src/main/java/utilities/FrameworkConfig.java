package utilities;

import org.aeonbits.owner.Config;

@Config.Sources({"file:${user.dir}/src/test/resources/Config/config.properties"})
public interface FrameworkConfig extends Config {

    String url();



}
