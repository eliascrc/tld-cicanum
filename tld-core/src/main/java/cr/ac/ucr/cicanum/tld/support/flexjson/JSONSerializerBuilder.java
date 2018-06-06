package cr.ac.ucr.cicanum.tld.support.flexjson;

import cr.ac.ucr.cicanum.tld.model.CicanumUser;
import cr.ac.ucr.cicanum.tld.model.MedicalService;
import cr.ac.ucr.cicanum.tld.model.ServiceManager;
import flexjson.JSONSerializer;
import flexjson.transformer.BooleanTransformer;
import flexjson.transformer.DateTransformer;
import flexjson.transformer.EnumTransformer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Builder class that holds several static factory methods for creating JSONSerializers with different include & exclude
 * rules
 */
public class JSONSerializerBuilder {

    private static final Logger logger = LoggerFactory.getLogger(JSONSerializerBuilder.class);

    private static final List<String> GLOBAL_INCLUDES = new LinkedList<>();

    static{
        GLOBAL_INCLUDES.add("entityCreationTimestamp");
        GLOBAL_INCLUDES.add("lastUpdatedTimestamp");
    }

    /**
     * Returns a list of paths to be excluded when creating a JSON serializer.
     * This list should be used for all JSON serializers created for the
     * application.
     *
     * @return a list of exclude paths to be used when creating a JSON
     * serializer for the app.
     */
    private static List<String> getGlobalExcludes() {
        List<String> excludes = new LinkedList<>();
        excludes.add("*.class");
        excludes.add("*.handler");
        excludes.add("*.hibernateLazyInitializer");
        return excludes;
    }

    /**
     * Gets a list of exclude expressions.
     *
     * @param clazz         the class to be inspected to exclude all fields but the ones sent in the include list.
     * @param attributeName the attribute name to be used as prefix in the exclude expressions.
     * @param include       the list of fields to include.
     */
    @SuppressWarnings("rawtypes")
    private static List<String> getExcludesForObject(Class clazz, String attributeName, List<String> include) {
        String prefix = "";

        if (attributeName != null && !attributeName.equals("")) {
            prefix = attributeName + ".";
        }
        List<String> excludes = new LinkedList<>();

        List<Field> fields = getInheritedPrivateFields(clazz);
        for (Field field : fields) {
            String fieldName = field.getName();

            if(!GLOBAL_INCLUDES.contains(fieldName) && (include == null || !include.contains(fieldName))) {
                excludes.add(prefix + fieldName);
            }
        }

        return excludes;
    }

    /**
     * Returns a list of the field methods for a given class, including the
     * inherited fields.
     *
     * @param type class type that will be introspected
     * @return a list of all the fields in the class hierarchy.
     */
    private static List<Field> getInheritedPrivateFields(Class<?> type) {
        List<Field> result = new ArrayList<>();

        Class<?> i = type;
        while (i != null && i != Object.class) {
            result.addAll(Arrays.asList(i.getDeclaredFields()));
            i = i.getSuperclass();
        }

        return result;
    }

    /**
     * Basic factory method that returns a JSONSerializer that realizes a shallow
     * serialization of objects excluding the objects' class names. Some attributes
     * from {@link cr.ac.ucr.cicanum.tld.model.BasicEntity} are also excluded.
     *
     * @return an instance of JSONSerializer that does shallow serialization excluding class names
     */
    public static JSONSerializer getBasicSerializer() {
        JSONSerializer serializer = new JSONSerializer();

        serializer.setExcludes(getGlobalExcludes());

        logger.trace("Basic Serializer {} created", serializer.toString());
        return serializer;
    }

    /**
     * Gets a JSONSerializer to use in order to obtain the JSON of a Cicanum User's information.
     *
     * @return the JSONSerializer to be used to serialize Cicanum User.
     */
    public static JSONSerializer getCicanumUserSerializer() {
        JSONSerializer serializer = getBasicSerializer();
        List<String> excludes = new LinkedList<>();
        List<String> tempIncludes = new LinkedList<>();

        excludes.addAll(getGlobalExcludes());

        tempIncludes.add("firstName");
        tempIncludes.add("lastName");
        tempIncludes.add("enabled");
        tempIncludes.add("resetPassword");
        tempIncludes.add("updateInformation");
        tempIncludes.add("group");
        tempIncludes.add("canSign");

        excludes.addAll(JSONSerializerBuilder.getExcludesForObject(CicanumUser.class, "", tempIncludes));

        serializer.setExcludes(excludes);

        serializer.transform(new BooleanTransformer(), "enabled");
        serializer.transform(new BooleanTransformer(), "resetPassword");
        serializer.transform(new BooleanTransformer(), "updateInformation");
        serializer.transform(new BooleanTransformer(), "canSign");

        // Logs the creation of the serializer
        logger.trace("Cicanum User Serializer {} created", serializer.toString());
        return serializer;
    }

    public static JSONSerializer getServiceManagerSerializer() {
        JSONSerializer serializer = getBasicSerializer();
        List<String> excludes = new LinkedList<>();
        List<String> tempIncludes;

        excludes.addAll(getGlobalExcludes());

        tempIncludes = new LinkedList<>();
        tempIncludes.add("serviceId");
        excludes.addAll(JSONSerializerBuilder.getExcludesForObject(MedicalService.class, "managedServices", tempIncludes));

        tempIncludes = new LinkedList<>();
        tempIncludes.add("firstName");
        tempIncludes.add("lastName");
        tempIncludes.add("enabled");
        tempIncludes.add("resetPassword");
        tempIncludes.add("updateInformation");

        excludes.addAll(JSONSerializerBuilder.getExcludesForObject(ServiceManager.class, "", tempIncludes));

        serializer.setExcludes(excludes);

        serializer.transform(new BooleanTransformer(), "enabled");
        serializer.transform(new BooleanTransformer(), "resetPassword");
        serializer.transform(new BooleanTransformer(), "updateInformation");

        // Logs the creation of the serializer
        logger.trace("Cicanum User Serializer {} created", serializer.toString());
        return serializer;
    }

    // TODO CCSS User Serializer

}