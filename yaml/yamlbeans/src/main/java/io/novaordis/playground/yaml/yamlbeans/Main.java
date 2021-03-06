/*
 * Copyright (c) 2016 Nova Ordis LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.novaordis.playground.yaml.yamlbeans;

import com.esotericsoftware.yamlbeans.YamlReader;

import java.io.File;
import java.io.FileReader;
import java.util.Map;

/**
 * @author Ovidiu Feodorov <ovidiu@novaordis.com>
 * @since 12/4/16
 */
public class Main {

    // Constants -------------------------------------------------------------------------------------------------------

    // Static ----------------------------------------------------------------------------------------------------------

    public static void main(String[] args) throws Exception {

        File file = parseCommandLine(args);
        FileReader fr = null;

        try {

            fr = new FileReader(file);

            YamlReader yamlReader = new YamlReader(new FileReader(file));

            Object o = yamlReader.read();

            Map m = (Map)o;

            Map s = (Map)m.get("service");
            Map l = (Map)m.get("load");

            Object threads = l.get("threads");

            System.out.println("threads: " + threads);

        }
        finally {

            if (fr != null) {
                fr.close();
            }
        }
    }

    // Attributes ------------------------------------------------------------------------------------------------------

    // Constructors ----------------------------------------------------------------------------------------------------

    // Public ----------------------------------------------------------------------------------------------------------

    // Package protected -----------------------------------------------------------------------------------------------

    // Protected -------------------------------------------------------------------------------------------------------

    // Private ---------------------------------------------------------------------------------------------------------

    private static File parseCommandLine(String[] args) throws Exception {

        if (args.length == 0) {

            throw new Exception("yaml file name not specified");
        }

        File f = new File(args[0]);

        if (!f.isFile() || !f.canRead()) {

            throw new Exception("file " + f + " does not exist or cannot be read");
        }

        return f;
    }

    // Inner classes ---------------------------------------------------------------------------------------------------

}
