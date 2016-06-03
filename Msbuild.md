# MSBuild Reference
## MSBuild Project File Schema Reference
	MSBuildファイル形式を構成するXML要素の概要
## MSBuild Task Reference
	MSBuildに付属する一般的なタスクについて
## MSBuild Conditions
	MSBuildファイルを使用できる条件について
## MSBuild Conditional Constructs
	Choose要素、When要素およびOtherwise要素の使用方法
## MSBuild Reserved and Well-Known Properties
	MSBuildの予約済みのプロパティについて
## Common MSBuild Proejct Properties
## Common MSBuild Project Items
## MSBuild Command-Line Reference

### Syntax

```
	MSBuild.exe [Switches] [ProjectFile]
```

### Arguments
	


### Switches

|Switch					|Short form		|Description				|
|:----------------------|:--------------|:--------------------------|
|/help					|/? or /h		|Display usage information.	|
|/detailedsummary		|/ds			|Show detailed information at the end of the build log 							|
|/target:targets		|/t:targets		|Build the specified targets in the project.							|
|/property:name=value	|/p:name=value	|Set or Override the specified project-level properties,where name is the property name and value is the property value.							|
|/preprocess[:filepath]	|/pp[:filepath]	|							|
|						|				|							|
|						|				|							|
|						|				|							|
|						|				|							|
|						|				|							|
|						|				|							|
|						|				|							|
|						|				|							|
|						|				|							|
|						|				|							|
|						|				|							|
|						|				|							|
|						|				|							|
|						|				|							|
|						|				|							|
|						|				|							|
|						|				|							|
|						|				|							|
|						|				|							|
|						|				|							|
|						|				|							|
|						|				|							|
|						|				|							|
|						|				|							|
							
### Example

```
	MSBuild $(SolutionFile) /t:Rebuild /p:Configuration=Debug 
```

## MSBuild .Targets Files
## MSBuild Well-known Item Metadata
## MSBuild Response Files
## Additional Resources for MSBuild
## WPF MSBuild Reference
## Special Characters to Escape
	状況によって、正しく解釈される為にｒ



:HelloWorld.cs
```
	using System;
	
	class HelloWorld{
		static void	Main(){
	#if DebugConfig
			Console.WriteLine( "WE are in the debug  cofiguration" );
	#endif
			Console.WriteLine( "Hello, world" );
		}
	}
```

ProjetFile
```
<Project xmlns="http:schemas.microsoft.com/developer/msuild/2003">

	<ItemGroup>
		<Compile Include="HelloWorld.cs" />
	</ItemGroup>
	
	
	<Target Name="Build">
		<Csc Sources="@(complie)" />
	</Target>

</Project>
```


