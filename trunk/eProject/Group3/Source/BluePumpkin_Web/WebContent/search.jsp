<form action="" method="post">
	<div class="search">
		<input name="searchword" id="mod_search_searchword" maxlength="20" alt="Search" class="inputbox" type="text" size="20" value="search..." onblur="if(this.value=='') this.value='search...';" onfocus="if(this.value=='search...') this.value='';" />
		<input type="submit" value="Search" class="button" 	onclick="this.form.searchword.focus();" />
	</div>
		<input type="hidden" name="task" value="search" /> 
		<input type="hidden" name="option" value="com_search" /> 
		<input type="hidden" name="Itemid"	value="1" />
</form>