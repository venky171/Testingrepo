package com.mohap.core;


import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.openqa.selenium.support.FindBy;
import org.reflections.Reflections;
import org.reflections.scanners.ResourcesScanner;
import org.reflections.scanners.SubTypesScanner;
import org.reflections.util.ClasspathHelper;
import org.reflections.util.ConfigurationBuilder;
import org.reflections.util.FilterBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



/** It contains all operations related to reflections.
 * 
 * @author Jaikant
 *
 */
public class ReflectionUtils {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ReflectionUtils.class);

	/** It will return map of classes and their @Test annotated test methods, example below : 
	  For example : class where method is present : AdminTest 
	   @Test(testName="ADMIN_TEST__100")
	   public void add_new_work_skill() {}
	
	 * e.g map : AdminTest={KEY="ADMIN_TEST__100", value= "add_new_work_skill"}
	 * @param packagePath where classes to be scanned.
	
	 * @return map of classes and their methods.
	 */
	public static Map<String, Map<String, String>> getClassAndTests(String packagePath) {
		Map<String, Map<String, String>> testNamesCache = new LinkedHashMap<>();
		List<Class<? extends Object>> classes = getAllClasses(packagePath);

		classes.forEach(klass -> {
			
			Map<String, String> testIdNamePair = new LinkedHashMap<>();
			String className = klass.getName().split("\\.")[klass.getName().split("\\.").length - 1];
			LOGGER.info("Class present in [{}] is [{}]", packagePath, className );
			List<Method> methods = findAnnotatedMethods(klass, org.testng.annotations.Test.class);
			methods.forEach(method -> {
				String testCaseName = method.getName();
				String testCaseId = method.getAnnotation(org.testng.annotations.Test.class).testName();
				if (!testCaseId.isEmpty()) {
					testIdNamePair.put(testCaseId, testCaseName);
				}
			});
			testNamesCache.put(className, testIdNamePair);
		});
		
		return testNamesCache;
		
		
	}

	/** It will return list of methods which has annotation present as specified in parameter.
	 * @param clazz classes where annotated methods to be scanned
	 * @param annotationClass
	 * @return list of methods which has annotation present as specified in parameter.
	 */
	public static List<Method> findAnnotatedMethods(Class<?> clazz, Class<? extends Annotation> annotationClass) {
		Method[] methods = clazz.getMethods();
		List<Method> annotatedMethods = new ArrayList<Method>(methods.length);
		for (Method method : methods) {
			if (method.isAnnotationPresent(annotationClass)) {
				annotatedMethods.add(method);
			}
		}

		return annotatedMethods;
	}

	/** It will return list of all classes present in the specified package that extends BaseConfiguration class.
	 * @param packagePath
	 * @return list of all classes present in the specified package.
	 */
	public static List<Class<? extends Object>> getAllClasses(String packagePath) {
		List<ClassLoader> classLoadersList = new LinkedList<ClassLoader>();
		classLoadersList.add(ClasspathHelper.contextClassLoader());
		classLoadersList.add(ClasspathHelper.staticClassLoader());

		Reflections reflections = new Reflections(new ConfigurationBuilder()
				.setScanners(new SubTypesScanner(false /* don't exclude Object.class */), new ResourcesScanner())
				.setUrls(ClasspathHelper.forClassLoader(classLoadersList.toArray(new ClassLoader[0])))
				.filterInputsBy(new FilterBuilder().include(FilterBuilder.prefix(packagePath))));

		return reflections.getSubTypesOf(BaseConfiguration.class).stream().collect(Collectors.toList());

	}
	
	
	/**It will give all classes of a package
	 * @param packagePath
	 * @return Map e.g below
	 * {
 		MLoginActions = {
   		passwordField_id = password,
   		usernameField_id = username,
   		loginBtn_id = com.Splitwise.SplitwiseMobile:id/loginButton
  		}, 
  		LoginActions = {
   		passwordField_id = password,
   		errorMessage_css = input[name = 'delsession'],
   		usernameField_id = username
  	}
}
	 */
	public static void recordLocators (String packagePath, Map<String,Map<String,String>> orMap) {
		Reflections reflections = new Reflections(packagePath, new SubTypesScanner(false));
		List<Class<? extends Object>> allClasses = reflections.getSubTypesOf(Object.class).stream()
				.collect(Collectors.toList());
		
		allClasses.forEach(klass -> {
			String className = klass.getName().split("\\.")[klass.getName().split("\\.").length - 1];
			Map<String,String> or = new HashMap<>(); // class specific locator map
			
			List<Field> fields = Arrays.asList(klass.getDeclaredFields());
			fields.forEach(field -> {
				if (field.isAnnotationPresent(FindBy.class)) {
					String locatorType = field.getAnnotation(FindBy.class).how().name().toLowerCase();
					String locatorName = field.getName();
					String locatorValue = field.getAnnotation(FindBy.class).using();
					or.put(locatorName, locatorValue + "_" + locatorType);
				}
			});
			orMap.put(className, or);  // global object repository
		});
		
		LOGGER.info("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
		LOGGER.info("Package : {}", packagePath);
		LOGGER.info("Locators : {}", orMap);
		LOGGER.info("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
	}
	
}
