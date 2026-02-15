# 🚀 Scalable Java Test Automation Framework

## 📌 Overview
A **scalable Java-based Test Automation Framework** powered by **Maven** and **TestNG**, seamlessly integrated with **LambdaTest** for cloud execution.  
Built for **cross-browser compatibility**, **headless execution**, and **parallel scalability**, this framework accelerates testing cycles and improves coverage.

---

## ✨ Features
- ✅ **Java + Maven** for build automation and dependency management  
- ✅ **TestNG** for testing and reporting  
- ✅ **LambdaTest integration** for cloud-based execution  
- ✅ **Cross-browser testing** (Chrome, Firefox, Edge, etc.)  
- ✅ **Headless execution** for faster CI/CD runs  
- ✅ **Parallel execution** to reduce test cycle time  
- ✅ **ExtentReports integration** for rich HTML reporting with screenshots and detailed logs  
- ✅ **Log4j logging** for configurable, structured logging across test lifecycle  
- ✅ **Data-driven testing** with support for **Excel, CSV, and JSON** files  
- ✅ **Scalable design** for enterprise-grade automation needs  

---

## 📂 Project Structure
<pre>
enterprise-selenium-automation-framework/
├── .settings/                      # IDE configuration (optional)
├── src/
│   └── test/
│       ├── java/
│       │   └── com/
│       │       ├── constants/          # Enums (Browser, Env)
│       │       │
│       │       ├── factory/            # DriverFactory (ThreadLocal)
│       │       │   └── DriverFactory.java
│       │       │
│       │       ├── ui/
│       │       │   ├── pages/          # Page Object Model classes
│       │       │   │   ├── HomePage.java
│       │       │   │   ├── LoginPage.java
│       │       │   │   └── MyAccountPage.java
│       │       │   │
│       │       │   ├── tests/          # Test classes
│       │       │   │   ├── TestBase.java
│       │       │   │   └── LoginTest.java
│       │       │   │
│       │       │   └── pojo/           # POJOs (User, Config, Environment)
│       │       │
│       │       ├── dataproviders/      # TestNG DataProviders
│       │       │
│       │       ├── listeners/          # TestNG listeners (Retry, Extent)
│       │       │
│       │       └── utility/            # Common utilities
│       │           ├── BrowserUtility.java
│       │           ├── JSONUtility.java
│       │           ├── LocatorFactory.java
│       │           ├── PropertiesUtil.java
│       │           ├── EnvironmentManager.java
│       │           └── LoggerUtility.java
│       │
│       └── resources/
│           ├── config/
│           │   └── config.json             # Centralized environment config
│           │
│           ├── locators/
│           │   ├── homePage.properties
│           │   ├── loginPage.properties
│           │   └── myAccountPage.properties
│           │
│           ├── testdata/
│           │   ├── loginData.json
│           │   ├── loginData.csv
│           │   └── loginData.xlsx
│           │
│           └── log4j2.xml                  # Logging configuration
│
├── .gitignore
├── pom.xml                                 # Maven dependencies & Surefire config
├── testng.xml                              # TestNG suite
└── README.md                               # Framework documentation (recommended)

</pre>

## ⚡ Getting Started

### 🔧 Prerequisites
- Install **Java 11+**
- Install **Maven 3.6+**
- IDE (IntelliJ IDEA / Eclipse recommended)

### ▶️ Running Tests
1. Clone the repository:
   ```bash
   git clone https://github.com/<your-username>/automation_assignment.git

2. Navigate to the project directory:
cd automation_assignment
Run tests with Maven: mvn clean test -Dbrowser=chrome -DisLamdaTest=false -DisHeadless=false -Denv=QA
3. Execute on LambdaTest (update credentials ).

**Cloud Execution (LambdaTest)**
Configure your LambdaTest credentials in the project config.

Supports running tests across multiple browsers and OS combinations.

Enables parallel execution for faster feedback cycles.

📊 **Reporting & Logging**
**ExtentReports** → Interactive HTML reports with screenshots, logs, and test status.

**TestNG Reports** → Default execution summary.

**Log4j** → Centralized, configurable logging for debugging and monitoring.

📑 **Data-Driven Testing**
Supports Excel, CSV, and JSON as data sources.

Enables parameterized test execution with dynamic datasets.

Simplifies regression testing by separating test logic from test data.

🤝 **Contributing**
Contributions are welcome!

Fork the repo

Create a feature branch

Submit a pull request
