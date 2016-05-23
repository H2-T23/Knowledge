function eventID
{
	[System.Reflection.Assembly]::LoadWithPartialName("System.Text.StringBuilder")
	[System.Reflection.Assembly]::LoadWithPartialName("System.Diagnostics.EventLog")
	
	$logs	= new-object Diagnostics.EventLog("System", ".")
	$sb		= new-object Text.StringBuilder
	
	
	$from	= "04/01/2016 00:00:00"
	$to		= "05/01/2016 00:00:00"
	
	foreach($log in $logs Entries){
		if( ($log.EventID -eq 12) -or ($log.EventID -eq 13) ){
			if( ($log.TimeGenerated -ge $from) -and ($log.TimeGenerated -lt $to) ){
				Write-Host "$($log.EntryType) $($log.Source) $($log.TimeGenerated) $($log.EventID) ($($log.InstanceID))"
			}
		}
	}
}
eventID
