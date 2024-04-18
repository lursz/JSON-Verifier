# JSON Verifier
## Description 
The main idea behind this project is to write a method verifying the input JSON data. Input data format is defined as AWS::IAM::Role Policy - definition and example [here](https://docs.aws.amazon.com/AWSCloudFormation/latest/UserGuide/aws-properties-iam-role-policy.html). Input JSON might be read from a file. 
Method shall return logical false if an input JSON Resource field contains a single asterisk and true in any other case.  
Example JSON:
```json
{
    "PolicyName": "root",
    "PolicyDocument": {
        "Version": "2012-10-17",
        "Statement": [
            {
                "Sid": "IamListAccess",
                "Effect": "Allow",
                "Action": [
                    "iam:ListRoles",
                    "iam:ListUsers"
                ],
                "Resource": "*"
            }
        ]
    }
}
```

## Run 
In order to run the project, you must have Java 21 installed on your machine. You can install it with
```bash
sudo apt install openjdk-21-jdk
```
Then, you can run the project with the following command:
```bash
java -jar VerifyJSON.jar <path_to_file>
```
where `<path_to_file>` is the path to the file containing the JSON data.


## Technology stack
- `Java 21`
- `Maven`
- `JUnit`
- `Jackson` 